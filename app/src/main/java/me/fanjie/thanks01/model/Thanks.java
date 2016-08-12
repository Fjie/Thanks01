package me.fanjie.thanks01.model;

import java.io.Serializable;

/**
 * Created by fanji on 2015/10/6.
 */
public class Thanks implements Serializable {

    private String content;
    private User sendUser;
    private Event event;
    private String date;

    public Thanks(Event event, User sendUser, String content) {
        this.event = event;
        this.sendUser = sendUser;
        this.content = content;
    }

    public Thanks(Event event, User user) {
        this.event = event;
        this.sendUser = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSendUser() {
        return sendUser;
    }

    public void setSendUser(User sendUser) {
        this.sendUser = sendUser;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
