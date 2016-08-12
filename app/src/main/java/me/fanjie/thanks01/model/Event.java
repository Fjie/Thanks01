package me.fanjie.thanks01.model;

import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fanji on 2015/9/27.
 */
public class Event implements Serializable {

    private String title;
    private String type;
    private String issueTime;
    private String endTime;
    private User user;
//    private AMapLocation location;
    private MarkerOptions marker;
    private int id;
    private LatLng latLng;
    private List<User> resultUsers;

    public Event(String title, User user, LatLng latLng) {
        this.title = title;
        this.user = user;
        this.latLng = latLng;
//        this.location = location;
        marker = new MarkerOptions();
        id = marker.hashCode();
    }

    public Event(String title, String type, User user) {
        this.title = title;
        this.type = type;
        this.user = user;
    }
    public Event(String title, User user) {
        this.title = title;
        this.user = user;
    }

    public LatLng getLatLng() {
//        latLng = new LatLng(location.getLatitude(),location.getLongitude());
        return latLng;
    }

    public List<User> getResultUsers() {
        return resultUsers;
    }

    public void setResultUsers(List<User> resultUsers) {
        this.resultUsers = resultUsers;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public AMapLocation getLocation() {
//        return location;
//    }
//
//    public void setLocation(AMapLocation location) {
//        this.location = location;
//    }

    public MarkerOptions getMarker() {
        return marker;
    }

    public void setMarker(MarkerOptions marker) {
        this.marker = marker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
