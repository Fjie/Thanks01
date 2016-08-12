package me.fanjie.thanks01.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.fanjie.thanks01.R;
import me.fanjie.thanks01.controller.Util;
import me.fanjie.thanks01.model.User;

/**
 * Created by fanji on 2015/9/28.
 */
public class UserAdapter extends BaseAdapter{
    private Context context;
    private List<User> users;

    public UserAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return users.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = users.get(position);
        View view;
        Hander hander;
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_user_list_item,null);
            hander = new Hander();
            hander.userImage = (ImageView) view.findViewById(R.id.userImage);
            hander.userName = (TextView) view.findViewById(R.id.userName);
            hander.userResume = (TextView) view.findViewById(R.id.userResume);
            view.setTag(hander);
        }else {
            view = convertView;
            hander = (Hander) view.getTag();
        }
        new Util().setHttpImage(hander.userImage, hander.userImage.getLayoutParams().width);
        hander.userName.setText(user.getName());
        hander.userResume.setText(user.getResume());

        final User userForSend = user;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack = (OnItemClickCallBack) context;
                onItemClickCallBack.onUserItemClick(userForSend);
            }
        });
        return view;
    }


    private class Hander{
        TextView userName,userResume;
        ImageView userImage;
    }

    public interface OnItemClickCallBack{
        void onUserItemClick(User user);
    }

    private OnItemClickCallBack onItemClickCallBack;

}
