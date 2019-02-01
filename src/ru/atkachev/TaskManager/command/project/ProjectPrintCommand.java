package ru.atkachev.TaskManager.command.project;

import ru.atkachev.TaskManager.api.IServiceLocate;
import ru.atkachev.TaskManager.command.AbstractCommand;
import ru.atkachev.TaskManager.entity.Project;

import java.util.List;
import java.util.Scanner;

public class ProjectPrintCommand extends AbstractCommand {

    public ProjectPrintCommand(IServiceLocate serviceLocate){
        super(serviceLocate);
    }

    final private Scanner scanner = new Scanner(System.in);
    final private List<Project> projects = serviceLocate.getProjectService().getProjectList();

    public String command(){
        return "pr p";
    }

    public void execute(){
        if (projects.isEmpty()){
            System.out.println("Empty");
        }
        for ( int i = 0; i < projects.size(); i++ ){
            System.out.printf("%s. %s %.8s%n", i + 1, projects.get(i).getName(), projects.get(i).getId());
        }
    }

    public String description(){
        return "Print projects";
    }
}
