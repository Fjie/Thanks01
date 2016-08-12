package me.fanjie.thanks01.model;

import java.io.Serializable;

/**
 * Created by fanji on 2015/10/6.
 */
public class MyMessage implements Serializable {

    public static final int BE_USER_CALL = 65146;
    public static final int HAVE_PEOPLE_WILLING = 51158;
    public static final int BE_USER_SELETE = 65582;
    public static final int GET_USER_THANKS = 68782;

    private String titleType;
    private String content;
    private User sendUser;
    private Event event;
    private int messageType;

    public MyMessage(Event event, User sendUser, int messageType) {
        if (messageType != GET_USER_THANKS) {
            this.content = "#" + event.getType() + "#" + event.getTitle();
        }
        this.event = event;
        this.sendUser = sendUser;
        this.messageType = messageType;
    }

    public String getTitleType() {
        switch (messageType){
            case BE_USER_CALL:
                titleType = "@了你";
                break;
            case HAVE_PEOPLE_WILLING:
                titleType = "表示愿意";
                break;
            case BE_USER_SELETE:
                titleType = "选择了你";
                break;
            case GET_USER_THANKS:
                titleType = "发来感谢";
                break;
            default:
                titleType = "其他消息";

        }
        return titleType;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}
