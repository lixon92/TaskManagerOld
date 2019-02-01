package command.Task;

import api.IServiceLocate;
import command.AbstractCommand;

import java.util.Scanner;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    private final Scanner scanner = new Scanner(System.in);
    private String nameTask, descriptionTask, projectId;
    int numberTask;

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
