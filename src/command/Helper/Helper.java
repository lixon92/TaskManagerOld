package command.Helper;

import api.IServiceLocate;
import command.AbstractCommand;
import entity.Project;

import java.util.List;

public class Helper extends AbstractCommand {
    public Helper(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "1";
    }

    @Override
    public void execute() {

        serviceLocate.getProjectService().createProject("Project_test1", "");
        serviceLocate.getProjectService().createProject("Project_test2", "");

        serviceLocate.getTaskService().createTask("Task_test1", "");
        serviceLocate.getTaskService().createTask("Task_test2", "");

        List<Project> projects = serviceLocate.getProjectService().getProjectList();

        for ( int i = 0; i < projects.size(); i++ ){
            System.out.println( i + 1 + ". " + projects.get(i).getName() + " " + projects.get(i).getId());
        }

    }

    @Override
    public String description() {
        return "Create test cases";
    }
}
