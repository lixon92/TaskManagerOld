package ru.atkachev.TaskManager.command;

import ru.atkachev.TaskManager.api.IServiceLocate;

public abstract class AbstractCommand {

    protected IServiceLocate serviceLocate;
    public AbstractCommand(IServiceLocate serviceLocate){
        this.serviceLocate = serviceLocate;
    };
    public abstract String command();
    public abstract void execute();
    public abstract String description();
}
