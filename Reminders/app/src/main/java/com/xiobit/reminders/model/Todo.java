package com.xiobit.reminders.model;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by onix on 6/30/15.
 */
public class Todo extends RealmObject {

    private String name;
    private Date date;
    private int priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
