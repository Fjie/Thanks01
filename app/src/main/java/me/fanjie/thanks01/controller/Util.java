package me.fanjie.thanks01.controller;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import me.fanjie.thanks01.model.Event;

/**
 * Created by fanji on 2015/9/27.
 */
public class Util {

    private static final int BITMAP_OK = 99999;
    private static final int CIRCLE_L = 56;
    private Service s = new Service();
    private Test t = new Test();

    public void addMarkers(Activity activity,AMap map,LatLng latLng){
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int l = (int) (CIRCLE_L*metrics.xdpi/160);
        List<Event> events = s.getEvents(latLng);
        for (Event e : events) {
            addMarker(map, e, l);
        }
    }
    public void addMarkers(Activity activity,AMap map,List<Event> events){
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int l = (int) (CIRCLE_L*metrics.xdpi/160);
        for (Event e : events) {
            addMarker(map, e, l);
        }
    }

    public void addMarker(final AMap aMap, final Event event, final int l){
        final Bitmap[] b = new Bitmap[1];
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == BITMAP_OK){
                    MarkerOptions marker = new MarkerOptions();
                    marker.position(event.getLatLng());
                    marker.title(event.getType());
                    marker.snippet(event.getTitle());
                    marker.icon(BitmapDescriptorFactory.fromBitmap(b[0]));
                    aMap.addMarker(marker);

                }
            }
        };
        new Thread(){
            @Override
            public void run() {
                try {
                    b[0] = getCircleBitmap(BitmapFactory.decodeStream(new URL(t.getUrl()).openStream()),l);
                    handler.sendEmptyMessage(BITMAP_OK);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void setHttpImage(final ImageView view,final int l){
        final Bitmap[] b = new Bitmap[1];
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == BITMAP_OK){
                    view.setImageBitmap(b[0]);
                }
            }
        };
        new Thread(){
            @Override
            public void run() {
                try {
                    b[0] = getCircleBitmap(BitmapFactory.decodeStream(new URL(t.getUrl()).openStream()),l);
                    handler.sendEmptyMessage(BITMAP_OK);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public Bitmap getCircleBitmap(Bitmap bitmap,int l){
        Bitmap bitmapBackground = Bitmap.createBitmap(l,l,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapBackground);
        Paint p = new Paint();
        p.setAntiAlias(true);
        RectF rect = new RectF(0,0,l,l);
        canvas.drawRoundRect(rect,l/2,l/2,p);
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, null, rect, p);
        return bitmapBackground;
    }
}
