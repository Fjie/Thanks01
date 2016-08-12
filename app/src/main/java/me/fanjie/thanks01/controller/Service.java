package me.fanjie.thanks01.controller;

import com.amap.api.maps2d.model.LatLng;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.fanjie.thanks01.model.BonusEvent;
import me.fanjie.thanks01.model.CallPeopleEvent;
import me.fanjie.thanks01.model.Event;
import me.fanjie.thanks01.model.GroupsUser;
import me.fanjie.thanks01.model.HelpEvent;
import me.fanjie.thanks01.model.MyMessage;
import me.fanjie.thanks01.model.Thanks;
import me.fanjie.thanks01.model.User;

/**
 * Created by fanji on 2015/9/27.
 */
public class Service {

    private Test t = new Test();
    private int MAX = 20;

    public List<Thanks> getThanks(int count) {
        List<Thanks> thankses = new ArrayList<>();
        Thanks thanks;
        for (int i = 0; i < count; i++) {
            thanks = new Thanks(getEvent(),getUser(),t.getThanksString());
            thanks.setDate(t.getEventDate());
            thankses.add(thanks);
        }
        return thankses;
    }

    public List<MyMessage> getMessages(int count) {
        List<MyMessage> myMessages = new ArrayList<>();
        MyMessage myMessage;
        for (int i = 0; i < count; i++) {
            if (t.getB()) {
                if (t.getB()) {
                    myMessage = new MyMessage(getEvent(), getUser(), MyMessage.BE_USER_SELETE);
                } else {
                    myMessage = new MyMessage(getEvent(), getUser(), MyMessage.BE_USER_CALL);
                }
            } else {
                if (t.getB()) {
                    myMessage = new MyMessage(getEvent(), getUser(), MyMessage.HAVE_PEOPLE_WILLING);
                } else {
                    myMessage = new MyMessage(getEvent(), getUser(), MyMessage.GET_USER_THANKS);
                    myMessage.setContent(t.getThanksString());
                }
            }
            myMessages.add(myMessage);
        }
        return myMessages;
    }

    public Event getEvent(int i, LatLng latLng) {
        List<Event> l = getEvents(latLng);
        return l.get(t.getN(l.size()));
    }

    public List<Event> getEvents(int count) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Event event;
            if (t.getB()) {
                if (t.getB()) {
                    event = new BonusEvent(t.getBonusEventTitle(), getUser());
                    event.setResultUsers(getUsers(t.getN(1,10)));
                    event.setEndTime(t.getEventDate());
                } else {
                    event = new CallPeopleEvent(t.getCallPeopleEventTitle(), getUser());
                    event.setResultUsers(getUsers(t.getN(0,15)));
                    event.setEndTime(t.getEventDate());
                }
            } else {
                if (t.getB()) {
                    event = new HelpEvent(t.getHelpEventTitle(), getUser());
                    event.setResultUsers(getUsers(t.getN(0,5)));
                    event.setEndTime(t.getEventDate());
                } else {
                    event = new CallPeopleEvent(t.getCallPeopleEventTitle(), getUser());
                    event.setResultUsers(getUsers(t.getN(0,15)));
                    event.setEndTime(t.getEventDate());
                }
            }
            events.add(event);
        }
        return events;
    }

    public Event getEvent() {
        List<Event> l = getEvents(20);
        return l.get(t.getN(l.size()));
    }

    /**
     * 请求事件列表
     *
     * @param latLng
     * @return
     */
    public ArrayList<Event> getEvents(LatLng latLng) {
        ArrayList<Event> events = new ArrayList<>();
        LatLng mLatLng;
        Event event;
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            mLatLng = new LatLng(latLng.latitude + t.getD(), latLng.longitude + t.getD());
            if (r.nextBoolean()) {
                if (r.nextBoolean()) {
                    event = new BonusEvent(t.getBonusEventTitle(), getUser(), mLatLng);
                } else {
                    event = new CallPeopleEvent(t.getCallPeopleEventTitle(), getUser(), mLatLng);
                }
            } else {
                if (r.nextBoolean()) {
                    event = new HelpEvent(t.getHelpEventTitle(), getUser(), mLatLng);
                } else {
//                    event = new GiftEvent(t.getGiftEventTitle(), getUser(), mLatLng);
                    event = new CallPeopleEvent(t.getCallPeopleEventTitle(), getUser(), mLatLng);
                }
            }
            events.add(event);
        }
        return events;
    }

    /**
     * @param latLng
     * @return
     */
    public ArrayList<Event> getHelpEvents(LatLng latLng) {
        ArrayList<Event> events = new ArrayList<>();
        LatLng mLatLng;
        Event event;
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            mLatLng = new LatLng(latLng.latitude + t.getD(), latLng.longitude + t.getD());
            event = new HelpEvent(t.getHelpEventTitle(), getUser(), mLatLng);
            events.add(event);
        }
        return events;
    }

    /**
     * @param latLng
     * @return
     */
    public ArrayList<Event> getGuysEvents(LatLng latLng) {
        ArrayList<Event> events = new ArrayList<>();
        LatLng mLatLng;
        Event event;
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            mLatLng = new LatLng(latLng.latitude + t.getD(), latLng.longitude + t.getD());
            event = new CallPeopleEvent(t.getCallPeopleEventTitle(), getUser(), mLatLng);
            events.add(event);
        }
        return events;
    }

    /**
     * @param latLng
     * @return
     */
    public ArrayList<Event> getRedEvents(LatLng latLng) {
        ArrayList<Event> events = new ArrayList<>();
        LatLng mLatLng;
        Event event;
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            mLatLng = new LatLng(latLng.latitude + t.getD(), latLng.longitude + t.getD());
            event = new BonusEvent(t.getBonusEventTitle(), getUser(), mLatLng);
            events.add(event);
        }
        return events;
    }


    public User getUser() {
        return getUsers().get(getUsers().size() - 1);
    }

    /**
     * 请求用户列表
     *
     * @return
     */
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < MAX; i++) {
            users.add(new User(t.getUserName(), t.getUserType(), t.getUserResume(), i));
        }
        return users;
    }

    public ArrayList<User> getUsers(int j) {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < j; i++) {
            users.add(new User(t.getUserName(), t.getUserType(), t.getUserResume(), i));
        }
        return users;
    }

    public ArrayList<GroupsUser> getGroupUsers(int j) {
        ArrayList<GroupsUser> users = new ArrayList<>();
        for (int i = 0; i < j; i++) {
            users.add(new GroupsUser(t.getUserName(), t.getUserType(), t.getUserResume(), i));
        }
        return users;
    }

    /**
     * 请求用户好友列表
     *
     * @param userId
     * @return
     */
    public ArrayList<User> getFriends(int userId) {
        ArrayList<User> users = new ArrayList<>();
        return users;
    }



}
