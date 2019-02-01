package ru.atkachev.TaskManager.command.project;

import ru.atkachev.TaskManager.api.IServiceLocate;
import ru.atkachev.TaskManager.command.AbstractCommand;

import java.util.Scanner;

public class ProjectDeleteCommand extends AbstractCommand {

    public ProjectDeleteCommand(IServiceLocate serviceLocate) {

        super(serviceLocate);

    }

    final private Scanner scanner = new Scanner(System.in);

    public String command() {
        return "pr d";
    }

    public void execute() {
        int index;
        System.out.print("enter number of project: ");
        index = Integer.parseInt(scanner.nextLine()) - 1;
        serviceLocate.getProjectService().deleteProject(index);
    }

    public String description() {
        return "Delete project";
    }

}
