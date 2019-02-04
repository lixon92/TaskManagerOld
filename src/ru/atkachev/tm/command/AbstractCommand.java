package ru.atkachev.tm.command;

import ru.atkachev.tm.api.IServiceLocate;

public abstract class AbstractCommand {

    final protected IServiceLocate serviceLocate;
    public AbstractCommand(IServiceLocate serviceLocate){
        this.serviceLocate = serviceLocate;
    };
    public abstract String command();
    public abstract void execute();
    public abstract String description();
    public abstract boolean isSecure();
}
