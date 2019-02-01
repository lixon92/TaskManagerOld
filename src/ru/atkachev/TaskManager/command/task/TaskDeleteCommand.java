package ru.atkachev.TaskManager.command.task;

import ru.atkachev.TaskManager.api.IServiceLocate;
import ru.atkachev.TaskManager.command.AbstractCommand;

import java.util.Scanner;

public class TaskDeleteCommand extends AbstractCommand {

    public TaskDeleteCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    final private Scanner scanner = new Scanner(System.in);
    private int index;

    @Override
    public String command() {
        return "t d";
    }

    @Override
    public void execute() {
        System.out.print("enter number of task: ");
        index = Integer.parseInt(scanner.nextLine()) - 1;
        serviceLocate.getTaskService().deleteTask(index);
    }

    @Override
    public String description() {
        return "Delete selected task";
    }
}
