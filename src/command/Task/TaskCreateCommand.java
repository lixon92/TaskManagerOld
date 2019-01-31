package command.Task;

import api.IServiceLocate;
import command.AbstractCommand;

import java.util.Scanner;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    private final Scanner scanner = new Scanner(System.in);
    private String nameTask, descriptionTask, nameProject;
        public String command() {
        return "tc";
    }

    public void execute() {
        System.out.println("enter name of project");
        nameProject = scanner.nextLine();
        System.out.println("enter name task");
        nameTask = scanner.nextLine();
        System.out.println("enter description task");
        descriptionTask = scanner.nextLine();
        serviceLocate.getTaskService().createTask(nameTask, descriptionTask);
    }

    public String description() {
        return "Create new task";
    }
}
