package ru.atkachev.TaskManager.command.project;

import ru.atkachev.TaskManager.api.IServiceLocate;
import ru.atkachev.TaskManager.command.AbstractCommand;

import java.util.Scanner;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(IServiceLocate serviceLocate){
        super(serviceLocate);
    };

    final private Scanner scanner = new Scanner(System.in);
    private String nameProject, descriptionProject;

    public String command(){
        return "pr c";
    }

    public void execute(){
        System.out.println("enter name project: ");
        nameProject = scanner.nextLine();
        System.out.println("enter description project: ");
        descriptionProject = scanner.nextLine();
        serviceLocate.getProjectService().createProject(nameProject, descriptionProject);
    }

    public String description(){
        return "Create project";
    }
}
