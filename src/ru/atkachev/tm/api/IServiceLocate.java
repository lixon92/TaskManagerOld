package ru.atkachev.tm.api;

import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.service.ProjectService;
import ru.atkachev.tm.service.TaskService;
import ru.atkachev.tm.service.UserService;

import java.util.Map;

public interface IServiceLocate {

    public abstract ProjectService getProjectService();
    public abstract TaskService getTaskService();
    public abstract String getTerminalService();
    public abstract UserService getUserService();
    public abstract Map<String, AbstractCommand> getCommandList();

}
