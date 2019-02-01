package ru.atkachev.TaskManager.entity;

import java.util.Date;
import java.util.UUID;

public class Project {

    final private Date dateCreated = new Date();
    final private String id = UUID.randomUUID().toString();

    private String describe;
    private String name;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setDescribe(String describe){
        this.describe = describe;
    }
    public String getDescribe(){
        return describe;
    }

    public String  getId(){
        return id;
    }

    public Date getDateCreated (){
        return dateCreated;
    }

}
