package ru.atkachev.TaskManager.command.task;

import ru.atkachev.TaskManager.api.IServiceLocate;
import ru.atkachev.TaskManager.command.AbstractCommand;

import java.util.Scanner;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    final private Scanner scanner = new Scanner(System.in);
    private String nameTask, descriptionTask, projectId;
    private int numberTask;

        public String command() {
        return "t c";
    }

    public void execute() {

        System.out.println("enter number of project");
        numberTask = Integer.parseInt(scanner.nextLine()) - 1;
        projectId = serviceLocate.getProjectService().getProjectList().get(numberTask).getId();

        System.out.println("enter name of task");
        nameTask = scanner.nextLine();
        System.out.println("enter description of task");
        descriptionTask = scanner.nextLine();
        serviceLocate.getTaskService().createTask(projectId, nameTask, descriptionTask);
    }

    public String description() {
        return "Create task";
    }
}
