package command.Project;

import command.AbstractCommand;
import repository.ProjectRepository;

import java.util.Scanner;

public class CreateProjectCommand extends AbstractCommand {

    private Scanner scanner = new Scanner(System.in);
    private ProjectRepository projectRepository = new ProjectRepository();
    private String nameProject, descriptionProject;

    public String command(){
        return "project-create";
    }

    public void execute(){
        System.out.print("enter name project: ");
        nameProject = scanner.nextLine();
        System.out.print("enter description project: ");
        descriptionProject = scanner.nextLine();
        projectRepository.createProject(nameProject, descriptionProject);
    }

    public String description(){
        return "project-create";
    }
}
