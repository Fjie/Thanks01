package me.fanjie.thanks01.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import me.fanjie.thanks01.R;
import me.fanjie.thanks01.model.Thanks;
import me.fanjie.thanks01.model.User;

/**
 * Created by fanji on 2015/10/7.
 */
public class ThanksAdapter extends BaseAdapter {

    private Context context;
    private List<Thanks> thankses;
    private OnItemClickCallBack onItemClickCallBack;

    public ThanksAdapter(Context context, List<Thanks> thankses) {
        this.context = context;
        this.thankses = thankses;
    }

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }


    @Override
    public int getCount() {
        return thankses.size();
    }

    @Override
    public Object getItem(int position) {
        return thankses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Thanks thanks = thankses.get(position);
        View view;
        Hander hander;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_thanks_list_item, null);
            hander = new Hander();
            hander.sendUserName = (TextView) view.findViewById(R.id.sendUserName);
            hander.thanksDate = (TextView) view.findViewById(R.id.thanksDate);
            hander.thanksContent = (TextView) view.findViewById(R.id.thanksContent);
            hander.eventType = (TextView) view.findViewById(R.id.eventType);
            hander.eventTitle = (TextView) view.findViewById(R.id.eventTitle);
            view.setTag(hander);
        } else {
            view = convertView;
            hander = (Hander) view.getTag();
        }
        hander.sendUserName.setText(thanks.getSendUser().getName());
        hander.thanksDate.setText(thanks.getDate());
        hander.thanksContent.setText(thanks.getContent());
        hander.eventType.setText("#"+thanks.getEvent().getType()+"#");
        hander.eventTitle.setText(thanks.getEvent().getTitle());

        final User userForSend = thanks.getSendUser();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onMessageItemClick(userForSend);
            }
        });

        return view;
    }

    private class Hander {
        private TextView sendUserName;
        private TextView thanksDate;
        private TextView thanksContent;
        private TextView eventType;
        private TextView eventTitle;
    }

    public interface OnItemClickCallBack {
        void onMessageItemClick(User user);
    }

}
