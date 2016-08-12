package me.fanjie.thanks01.model;

import com.amap.api.maps2d.model.LatLng;

/**
 * Created by fanji on 2015/9/27.
 */
public class GiftEvent extends Event {
    public GiftEvent(String title,  User user,LatLng latLng) {
        super(title, user, latLng);
        super.setType("闲置物品");
    }
}
