package me.fanjie.thanks01;

import android.annotation.TargetApi;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.fanjie.thanks01.controller.Service;
import me.fanjie.thanks01.controller.Util;
import me.fanjie.thanks01.model.Event;
import me.fanjie.thanks01.model.User;
import me.fanjie.thanks01.view.EventContentActivity;
import me.fanjie.thanks01.view.InviteGuysActivity;
import me.fanjie.thanks01.view.IssueHelpActivity;
import me.fanjie.thanks01.view.MessageListActivity;
import me.fanjie.thanks01.view.RedPackesActivity;
import me.fanjie.thanks01.view.UserContentActivity;

public class MainActivity extends AppCompatActivity implements AMapLocationListener, LocationSource, AMap.OnMarkerClickListener, AMap.OnInfoWindowClickListener, NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private static final int SLEEP_OK = 64684754;
    private static final int REQUEST_CODE_ISSUE_EVENT = 5455;
    //    定位相关
    private LocationManagerProxy locationManagerProxy;
    private LatLng nowImHere;
    private AMapLocation location;
    //    地图相关
    private AMap aMap;
    private MapView mapView;
    private boolean isGetLocationOk = false;
    private boolean isAddMarkerOk = false;
    private Bundle savedInstanceState;
    //    抽屉导航相关
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private CharSequence title;
    private CharSequence drawerTitle;
    private boolean isDrawerOpen = false;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ImageView myImage;
    private TextView myName;
    private TextView myResume;
    private LinearLayout userPanel;
    //    其他
    private Util util = new Util();
    private Service service = new Service();
    private PopupWindow popupWindow;
    private PopupMenu filterPopupMenu;
    private User me;
    private float scale;//手机分辨率
    private int popupWindowHeight = 40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.savedInstanceState = savedInstanceState;
//        初始化工具条
        initToolBarAndMore();
//        初始化抽屉导航
        initDrawer();
//        初始化地图以及定位
        initMapAndMore();

    }


    private void initToolBarAndMore() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        scale = this.getResources().getDisplayMetrics().density;
    }

    private void initDrawer() {
        title = getTitle();
        drawerTitle = "啦啦啦";
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.hello_world, R.string.app_name);
// {
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//                toolbar.setTitle(title);
//
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//                toolbar.setTitle(drawerTitle);
//            }
//
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                super.onDrawerSlide(drawerView, slideOffset);
////                drawerView.setAlpha(slideOffset);
//            }
//        };
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        navigationView = (NavigationView) findViewById(R.id.left_drawer);
        myImage = (ImageView) navigationView.findViewById(R.id.userImage);
        myName = (TextView) navigationView.findViewById(R.id.userName);
        myResume = (TextView) navigationView.findViewById(R.id.userResume);
        userPanel = (LinearLayout) navigationView.findViewById(R.id.userPanel);
        me = new Service().getUser();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
        util.setHttpImage(myImage, myImage.getLayoutParams().width);
        myName.setText(me.getName());
        myResume.setText(me.getResume());
        userPanel.setOnClickListener(this);
    }

    private void initMapAndMore() {
        mapView = (MapView) findViewById(R.id.map);
        locationManagerProxy = LocationManagerProxy.getInstance(this);
        location = locationManagerProxy.getLastKnownLocation(LocationProviderProxy.AMapNetwork);
        if (location != null) {
            nowImHere = new LatLng(location.getLatitude(), location.getLongitude());
        } else {
            locationManagerProxy.requestLocationData(LocationProviderProxy.AMapNetwork, -1, 0, this);
        }
        //地图相关
        aMap = mapView.getMap();
        if (nowImHere != null) {
            aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nowImHere, 16));
            util.addMarkers(this, aMap, nowImHere);
            mapView.onCreate(savedInstanceState);
            isAddMarkerOk = true;
        }
        locationManagerProxy.requestLocationData(LocationProviderProxy.AMapNetwork, 10 * 1000, 15, this);
        aMap.getUiSettings().setZoomControlsEnabled(false);
        aMap.setOnInfoWindowClickListener(this);
        aMap.setOnMarkerClickListener(this);
        aMap.setLocationSource(this);
        aMap.getUiSettings().setMyLocationButtonEnabled(true);
        aMap.setMyLocationEnabled(true);
//        aMap.setInfoWindowAdapter(new AMap.InfoWindowAdapter() {
//            @Override
//            public View getInfoWindow(Marker marker) {
//                TextView textView = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_info_window,null);
//                textView.setText(marker.getSnippet());
//                return textView;
//            }
//
//            @Override
//            public View getInfoContents(Marker marker) {
//                return null;
//            }
//        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }


    /*
    * 标记监听
    * */
    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.isInfoWindowShown()) {
            startEventContent(marker);
            return true;
        } else {
            marker.showInfoWindow();
            return true;
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        startEventContent(marker);
    }

    private void startEventContent(Marker marker) {
        Event e = new Event(marker.getSnippet(), marker.getTitle(), new Service().getUser());
        EventContentActivity.startMyActivity(this, e);
    }

    /*
    * 点击监听
    * */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.issueEvent:
                if (popupWindow != null) {
                    showPopupWindow(view);
                } else {
                    //        初始化弹出菜单
                    initPopupWindow();
                    showPopupWindow(view);
                }
                break;
            case R.id.funIssueHelp:
                Intent i = new Intent(this, IssueHelpActivity.class);
                startActivityForResult(i, REQUEST_CODE_ISSUE_EVENT);
                break;
            case R.id.funInviteGuys:
                Intent i2 = new Intent(this, InviteGuysActivity.class);
                startActivityForResult(i2, REQUEST_CODE_ISSUE_EVENT);
                break;
            case R.id.funRedPackes:
                Intent i3 = new Intent(this, RedPackesActivity.class);
                startActivityForResult(i3, REQUEST_CODE_ISSUE_EVENT);
                break;
            case R.id.userPanel:
                UserContentActivity.startMyActivity(this, me);
                drawerLayout.closeDrawers();
                break;
        }
    }

    /*
    * 抽屉点击监听
    * */
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home:

                break;
            case R.id.nav_gallery:

                break;
            case R.id.nav_slideshow:

                break;
            case R.id.nav_manage:

                break;
            case R.id.nav_share:
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.setType("text/*");
                i.putExtra(Intent.EXTRA_TEXT, "这个屌炸天的应用，你为什么还没拥有？");
                startActivity(Intent.createChooser(i, "分享到"));
                break;
            case R.id.nav_send:

                break;

        }
        return false;
    }

    /*
    * 工具条按钮监听
    * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_notifications) {
            Intent i = new Intent(this, MessageListActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_filter) {
            if (filterPopupMenu == null) {
                filterPopupMenu = new PopupMenu(this, findViewById(R.id.action_filter));
                filterPopupMenu.getMenuInflater().inflate(R.menu.menu_popup_filter, filterPopupMenu.getMenu());
                filterPopupMenu.setOnMenuItemClickListener(this);
                filterPopupMenu.getMenu().findItem(R.id.action_all).setChecked(true);
            }
            filterPopupMenu.show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    //    工具条popup点击
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.action_filter_help:
                filterEvents(service.getHelpEvents(nowImHere));
                break;
            case R.id.action_filter_guys:
                filterEvents(service.getGuysEvents(nowImHere));
                break;
            case R.id.action_filter_red:
                filterEvents(service.getRedEvents(nowImHere));
                break;
            case R.id.action_all:
                filterEvents(service.getEvents(nowImHere));
                break;

        }
        return false;
    }

    private void filterEvents(List<Event> events) {
        List<Marker> markers = aMap.getMapScreenMarkers();
        if (markers != null) {
            for (Marker m : markers) {
                m.remove();
            }
        }
        util.addMarkers(this, aMap, events);
    }
    /*
* 地图相关各种方法
* */

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        this.location = aMapLocation;
        nowImHere = new LatLng(location.getLatitude(), location.getLongitude());
        if (!isGetLocationOk) {
            isGetLocationOk = true;
            aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nowImHere, 16));
            if (!isAddMarkerOk) {
                mapView.onCreate(savedInstanceState);
                util.addMarkers(this, aMap, nowImHere);
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    /*
    * 定位相关方法
    * */
    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        onLocationChangedListener.onLocationChanged(location);
    }

    @Override
    public void deactivate() {

    }

    /*
    * 地图相关复写方法
    * */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_ISSUE_EVENT) {
            popupWindow.dismiss();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    private void backgroundAlpha(float alpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = alpha;
        getWindow().setAttributes(lp);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void showPopupWindow(View view) {
        final Timer timer = new Timer(true);
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == SLEEP_OK) {
                    int i = msg.arg1;
                    if (i < 800) {
                        backgroundAlpha(1.0f - i / 1000f);
                    } else {
                        timer.cancel();
                    }

                }
            }
        };

        TimerTask timerTask = new TimerTask() {
            int i = 100;

            @Override
            public void run() {
                Message message = new Message();
                message.what = SLEEP_OK;
                message.arg1 = i;
                handler.sendMessage(message);
                i = i + 5;

            }
        };

        timer.schedule(timerTask, 0, 1);
        popupWindow.showAsDropDown(view, 0, (int) (32 * scale + 0.5f), Gravity.TOP);

    }

    private void initPopupWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_popup_window, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.color.popup_window_background));
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                final Timer timer = new Timer(true);
                final Handler handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        if (msg.what == SLEEP_OK) {
                            int i = msg.arg1;
                            if (i < 1000) {
                                backgroundAlpha(i / 1000f);
                            } else {
                                timer.cancel();
                            }

                        }
                    }
                };

                TimerTask timerTask = new TimerTask() {
                    int i = 200;

                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = SLEEP_OK;
                        message.arg1 = i;
                        handler.sendMessage(message);
                        i = i + 8;

                    }
                };

                timer.schedule(timerTask, 0, 1);
            }
        });

    }

}
