package ru.atkachev.tm.command.task;

import ru.atkachev.tm.api.IServiceLocate;
import ru.atkachev.tm.command.AbstractCommand;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "t c";
    }

    public void execute() {
        String nameTask, descriptionTask, projectId;
        int numberTask;

        System.out.println("enter number of project");
        numberTask = Integer.parseInt(serviceLocate.getTerminalService()) - 1;
        projectId = serviceLocate.getProjectService().getProjectList().get(numberTask).getId();

        System.out.println("enter name of task");
        nameTask = serviceLocate.getTerminalService();
        System.out.println("enter description of task");
        descriptionTask = serviceLocate.getTerminalService();
        serviceLocate.getTaskService().createTask(projectId, nameTask, descriptionTask);
    }

    public String description() {
        return "Create task";
    }
}
