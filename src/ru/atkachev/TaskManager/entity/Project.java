package ru.atkachev.TaskManager.entity;

import java.util.Date;
import java.util.UUID;

public class Project {

    private UUID uuid = UUID.randomUUID();
    private String id = uuid.toString();

    private String describe;
    private String name;
    private Date dateCreated = new Date();

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
