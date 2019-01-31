package bootstrap;

import command.AbstractCommand;
import command.Helper.Helper;
import command.Project.ProjectCreateCommand;
import command.Project.ProjectDeleteCommand;
import command.Project.ProjectPrintCommand;
import command.Task.TaskCreateCommand;
import command.Task.TaskPrintCommand;
import repository.ProjectRepository;
import repository.TaskRepository;
import service.ProjectService;
import service.TaskService;
import api.IServiceLocate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap implements IServiceLocate {

    private TaskRepository taskRepository = new TaskRepository();
    private ProjectRepository projectRepository = new ProjectRepository();

    private TaskService taskService = new TaskService(taskRepository);
    private ProjectService projectService = new ProjectService(projectRepository, taskRepository);

    private Scanner scanner = new Scanner(System.in);
    private final Map <String, AbstractCommand> commands = new HashMap<>();
    private String inputText;
    private AbstractCommand tempObj;
    public void init(){
        registry(new ProjectCreateCommand(this));
        registry(new ProjectPrintCommand(this));
        registry(new ProjectDeleteCommand(this));
        registry(new TaskCreateCommand(this));
        registry(new TaskPrintCommand(this));
        registry(new Helper(this));

        for(;;){
            inputText = scanner.nextLine();
            tempObj = commands.get(inputText);
            if (tempObj != null){
                System.out.println("[" + tempObj.description() + "]");
                tempObj.execute();
                System.out.println("[OK]");
            }
            else {
                System.out.println("[FAIL]");
            }
        }
    }

    private void registry(AbstractCommand abstractCommand){
        commands.put(abstractCommand.command(), abstractCommand);
    }
    public ProjectService getProjectService(){
        return projectService;
    }
    public TaskService getTaskService(){
        return taskService;
    }
}
