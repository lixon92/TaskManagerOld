package ru.atkachev.TaskManager.api;

import ru.atkachev.TaskManager.command.AbstractCommand;
import ru.atkachev.TaskManager.service.ProjectService;
import ru.atkachev.TaskManager.service.TaskService;

import java.util.Map;

public interface IServiceLocate {
    public abstract ProjectService getProjectService();
    public abstract TaskService getTaskService();
    public abstract Map<String, AbstractCommand> getCommandList();
}
