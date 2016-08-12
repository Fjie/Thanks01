package me.fanjie.thanks01.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import me.fanjie.thanks01.R;
import me.fanjie.thanks01.model.Event;
import me.fanjie.thanks01.model.User;

/**
 * Created by fanji on 2015/10/7.
 */
public class EventAdapter extends BaseAdapter {

    private Context context;
    private List<Event> events;
    private OnItemClickCallBack onItemClickCallBack;

    public EventAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }


    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Event event = events.get(position);
        View view;
        Hander hander;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_event_list_item, null);
            hander = new Hander();
            hander.eventTitle = (TextView) view.findViewById(R.id.eventTitle);
            hander.eventTime = (TextView) view.findViewById(R.id.eventTime);
            hander.eventType = (TextView) view.findViewById(R.id.eventType);
            hander.eventResultUserNames = (TextView) view.findViewById(R.id.eventResultUsers);
            hander.eventResultUserNamesDesc = (TextView) view.findViewById(R.id.eventResultUsersDesc);
            view.setTag(hander);
        } else {
            view = convertView;
            hander = (Hander) view.getTag();
        }

        hander.eventTitle.setText(event.getTitle());
        hander.eventType.setText("#"+event.getType()+"#");
        hander.eventTime.setText(event.getEndTime());
        StringBuffer sb = new StringBuffer("");
        List<User> users = event.getResultUsers();
        int j = users.size();
        for (int i = 0; i < j; i++) {
            sb.append(users.get(i).getName());
            if (i < j-1){
                sb.append(",");
            }
        }
        hander.eventResultUserNamesDesc.setText("等" + users.size() + "位用户");
        hander.eventResultUserNames.setText(sb.toString().isEmpty() ? "无用户" : sb.toString());


        final Event eventForSend = event;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onMessageItemClick(eventForSend);
            }
        });


        return view;
    }

    private class Hander {
        private TextView eventTitle;
        private TextView eventTime;
        private TextView eventType;
        private TextView eventResultUserNames;
        private TextView eventResultUserNamesDesc;
    }

    public interface OnItemClickCallBack {
        void onMessageItemClick(Event event);
    }

}
