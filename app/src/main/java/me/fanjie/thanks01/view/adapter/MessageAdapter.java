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
import me.fanjie.thanks01.model.MyMessage;
import me.fanjie.thanks01.model.User;

/**
 * Created by fanji on 2015/10/7.
 */
public class MessageAdapter extends BaseAdapter {

    private Context context;
    private List<MyMessage> myMessages;
    private OnItemClickCallBack onItemClickCallBack;

    public MessageAdapter(Context context, List<MyMessage> myMessages) {
        this.context = context;
        this.myMessages = myMessages;
    }

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }



    @Override
    public int getCount() {
        return myMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return myMessages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyMessage myMessage = myMessages.get(position);
        View view;
        Hander hander;
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_message_list_item,null);
            hander = new Hander();
            hander.messageTitle = view.findViewById(R.id.messageTitle);
            hander.messageTitleUserName = (TextView) view.findViewById(R.id.messageTitleUserName);
            hander.messageTitleType = (TextView) view.findViewById(R.id.messageTitleType);
            hander.messageContent = (TextView) view.findViewById(R.id.messageContent);
            view.setTag(hander);
        }else {
            view = convertView;
            hander = (Hander) view.getTag();
        }

        hander.messageTitleUserName.setText(myMessage.getSendUser().getName());
        hander.messageTitleType.setText(myMessage.getTitleType());
        hander.messageContent.setText(myMessage.getContent());

        final Event eventForSend = myMessage.getEvent();
        final User userForSend = myMessage.getSendUser();

        hander.messageTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onMessageItemTitleClick(userForSend);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onMessageItemClick(eventForSend);
            }
        });



        return view;
    }

    private class Hander{
        private View messageTitle;
        private TextView messageTitleUserName;
        private TextView messageTitleType;
        private TextView messageContent;
    }

    public interface OnItemClickCallBack{
        void onMessageItemClick(Event event);
        void onMessageItemTitleClick(User user);
    }

}
