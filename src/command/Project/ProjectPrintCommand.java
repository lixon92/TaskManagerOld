package command.Project;

import api.IServiceLocate;
import command.AbstractCommand;
import entity.Project;

import java.util.List;
import java.util.Scanner;

public class ProjectPrintCommand extends AbstractCommand {

    public ProjectPrintCommand(IServiceLocate serviceLocate){
        super(serviceLocate);
    }

    private Scanner scanner = new Scanner(System.in);

    public String command(){
        return "pr p";
    }

    public void execute(){

        List<Project> projects = serviceLocate.getProjectService().getProjectList();

        if (projects.isEmpty()){
            System.out.println("Empty");
        }
        for ( int i = 0; i < projects.size(); i++ ){
            //System.out.println( i + 1 + ". " + projects.get(i).getName() + " " + projects.get(i).getId());
            System.out.printf("%s. %s %.8s%n", i + 1, projects.get(i).getName(), projects.get(i).getId());
        }
    }

    public String description(){
        return "Print projects";
    }
}
