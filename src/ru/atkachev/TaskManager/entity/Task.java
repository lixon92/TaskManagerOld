package ru.atkachev.TaskManager.entity;

import java.util.Date;
import java.util.UUID;

public class Task {

    private UUID uuid = UUID.randomUUID();
    private String id = uuid.toString();
    private String projectId;
    private String describe;
    private String name;
    private Date dateCreated = new Date();

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectId() {
        return projectId;
    }

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