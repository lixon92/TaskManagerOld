package command.Project;

import api.IServiceLocate;
import command.AbstractCommand;
import repository.ProjectRepository;

import java.util.Scanner;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(IServiceLocate serviceLocate){
        super(serviceLocate);
    };

    private Scanner scanner = new Scanner(System.in);
    private String nameProject, descriptionProject;

    public String command(){
        return "c";
    }

    public void execute(){
        System.out.print("enter name project: ");
        nameProject = scanner.nextLine();
        System.out.print("enter description project: ");
        descriptionProject = scanner.nextLine();
        serviceLocate.getProjectService().createProject(nameProject, descriptionProject);
    }

    public String description(){
        return "It create project";
    }
}
