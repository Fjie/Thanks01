package me.fanjie.thanks01.model;

import java.io.Serializable;

/**
 * Created by fanji on 2015/9/27.
 */
public class User implements Serializable {

    private String name;
    private String Type;
    private String resume;
    private int id;

    public User(String name, String type, String resume, int id) {
        this.name = name;
        Type = type;
        this.resume = resume;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
