package me.fanjie.thanks01.model;

import com.amap.api.maps2d.model.LatLng;

/**
 * Created by fanji on 2015/9/27.
 */
public class BonusEvent extends Event {
    public BonusEvent(String title,  User user, LatLng latLng) {
        super(title, user, latLng);
        super.setType("抢红包");
    }

    public BonusEvent(String bonusEventTitle, User user) {
        super(bonusEventTitle, user);
        super.setType("抢红包");
    }
}
