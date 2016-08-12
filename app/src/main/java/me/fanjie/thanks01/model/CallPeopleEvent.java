package me.fanjie.thanks01.model;

import com.amap.api.maps2d.model.LatLng;

/**
 * Created by fanji on 2015/9/27.
 */
public class CallPeopleEvent extends Event {
    public CallPeopleEvent(String title,  User user,LatLng latLng) {
        super(title, user, latLng);
        super.setType("找伙伴");
    }

    public CallPeopleEvent(String callPeopleEventTitle, User user) {
        super(callPeopleEventTitle, user);
        super.setType("找伙伴");
    }
}
