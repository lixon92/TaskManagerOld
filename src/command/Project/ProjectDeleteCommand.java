package command.Project;

import api.IServiceLocate;
import command.AbstractCommand;

import java.util.Scanner;

public class ProjectDeleteCommand extends AbstractCommand {

    public ProjectDeleteCommand(IServiceLocate serviceLocate) {

        super(serviceLocate);

    }

    private final Scanner scanner = new Scanner(System.in);

    public String command() {

        return "r";

    }

    public void execute() {

        int index;
        System.out.print("enter number of project: ");
        index = Integer.parseInt(scanner.nextLine()) - 1;

        serviceLocate.getProjectService().deleteProject(index);

    }

    public String description() {

        return "project-delete";

    }

}
