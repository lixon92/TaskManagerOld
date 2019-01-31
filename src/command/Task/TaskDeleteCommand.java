package command.Task;

import api.IServiceLocate;
import command.AbstractCommand;

import java.util.Scanner;

public class TaskDeleteCommand extends AbstractCommand {

    public TaskDeleteCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    private Scanner scanner = new Scanner(System.in);
    @Override
    public String command() {
        return "tr";
    }

    @Override
    public void execute() {
        int index;
        System.out.print("enter number of task: ");
        index = Integer.parseInt(scanner.nextLine()) - 1;
        serviceLocate.getTaskService().deleteTask(index);
    }

    @Override
    public String description() {
        return "Delete selected task";
    }
}
