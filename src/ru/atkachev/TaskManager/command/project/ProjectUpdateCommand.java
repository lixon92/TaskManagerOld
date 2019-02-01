package ru.atkachev.TaskManager.command.project;

import ru.atkachev.TaskManager.api.IServiceLocate;
import ru.atkachev.TaskManager.command.AbstractCommand;

import java.util.Scanner;

public class ProjectUpdateCommand extends AbstractCommand {
    final private Scanner scanner = new Scanner(System.in);
    private int index;
    private String nameProject, descriptionProject;

    public ProjectUpdateCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "pr u";
    }

    @Override
    public void execute() {
        System.out.println("enter number project");
        index = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.println("enter new name project: ");
        nameProject = scanner.nextLine();

        System.out.println("enter new description project: ");
        descriptionProject = scanner.nextLine();

        serviceLocate.getProjectService().updateProject(index, nameProject, descriptionProject);
    }

    @Override
    public String description() {
        return "Update project";
    }
}
