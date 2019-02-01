package api;

import command.AbstractCommand;
import service.ProjectService;
import service.TaskService;

import java.util.Map;

public interface IServiceLocate {
    public abstract ProjectService getProjectService();
    public abstract TaskService getTaskService();
    public abstract Map<String, AbstractCommand> getCommandList();
}
