package ru.atkachev.TaskManager.command.helper;

import ru.atkachev.TaskManager.api.IServiceLocate;
import ru.atkachev.TaskManager.command.AbstractCommand;
import ru.atkachev.TaskManager.entity.Project;
import ru.atkachev.TaskManager.entity.Task;

import java.util.List;

public class Helper extends AbstractCommand {
    public Helper(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "1";
    }

    @Override
    public void execute() {

        serviceLocate.getProjectService().createProject("Project_test1", "");
        serviceLocate.getProjectService().createProject("Project_test2", "");

        serviceLocate.getTaskService().createTask("", "Task_test1", "");
        serviceLocate.getTaskService().createTask("", "Task_test2", "");

        List<Project> projects = serviceLocate.getProjectService().getProjectList();

        for ( int i = 0; i < projects.size(); i++ ){
            System.out.println( i + 1 + ". " + projects.get(i).getName() + " " + projects.get(i).getId());
        }

        List<Task> taskList = serviceLocate.getTaskService().getTaskList();

        int index = 0;
        for (Task task : taskList){
            System.out.println(index + 1 + ". " + task.getName() + " " + task.getId());
            index++;
        }
    }

    @Override
    public String description() {
        return "Create test cases";
    }
}
