package api;

import service.ProjectService;
import service.TaskService;

public interface IServiceLocate {
    public abstract ProjectService getProjectService();
    public abstract TaskService getTaskService();
}
