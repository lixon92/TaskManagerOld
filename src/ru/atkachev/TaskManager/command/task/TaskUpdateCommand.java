package ru.atkachev.TaskManager.command.task;

import ru.atkachev.TaskManager.api.IServiceLocate;
import ru.atkachev.TaskManager.command.AbstractCommand;

import java.util.Scanner;

public class TaskUpdateCommand extends AbstractCommand {

    public TaskUpdateCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    final private Scanner scanner = new Scanner(System.in);
    private int index;
    private String nameTask, descriptionTask;
    @Override
    public String command() {
        return "t u";
    }

    @Override
    public void execute() {
        System.out.println("enter number task");
        index = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.println("enter new name task: ");
        nameTask = scanner.nextLine();

        System.out.println("enter new description task: ");
        descriptionTask = scanner.nextLine();

        serviceLocate.getTaskService().updateTask(index, nameTask, descriptionTask);
    }

    @Override
    public String description() {
        return "Update task";
    }
}
