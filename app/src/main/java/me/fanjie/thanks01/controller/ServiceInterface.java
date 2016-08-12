package me.fanjie.thanks01.controller;

import java.util.List;

import me.fanjie.thanks01.model.Account;
import me.fanjie.thanks01.model.Event;
import me.fanjie.thanks01.model.GroupsUser;
import me.fanjie.thanks01.model.Place;
import me.fanjie.thanks01.model.User;

/**
 * Created by fanji on 2015/9/29.
 */
public interface ServiceInterface {
    /**
     *
     * @param event
     * @return
     */
    List<User> getGoodMans(Event event);

    /**
     *
     * @param user
     * @return
     */
    List<User> getFollows(User user);
    /**
     *
     * @param user
     * @return
     */
    List<User> getFuns(User user);
    /**
     *
     * @param user
     * @return
     */
    List<GroupsUser> getUsersPartys(User user);
    /**
     *
     * @param account
     * @return
     */
    List<Account> getPeopleHubs(Account account);

    /**
     *
     * @param account
     * @param place
     * @return
     */
    List<Event> getEvents(Account account,Place place);

    /**
     *
     * @param user
     * @return
     */
    User getCompleteUser(User user);

    /**
     *
     * @param event
     * @return
     */
    Event getCompleteEvent(Event event);

}
