package me.fanjie.thanks01.model;

import com.amap.api.maps2d.model.LatLng;

/**
 * Created by fanji on 2015/9/27.
 */
public class HelpEvent extends Event {
    public HelpEvent(String title,  User user, LatLng latLng) {
        super(title, user, latLng);
        super.setType("求帮助");
    }

    public HelpEvent(String helpEventTitle, User user) {
        super(helpEventTitle, user);
        super.setType("求帮助");
    }
}
