package ru.atkachev.TaskManager.bootstrap;

import ru.atkachev.TaskManager.command.AbstractCommand;
import ru.atkachev.TaskManager.command.helper.HelpCommand;
import ru.atkachev.TaskManager.command.helper.Helper;
import ru.atkachev.TaskManager.command.project.ProjectCreateCommand;
import ru.atkachev.TaskManager.command.project.ProjectDeleteCommand;
import ru.atkachev.TaskManager.command.project.ProjectPrintCommand;
import ru.atkachev.TaskManager.command.project.ProjectUpdateCommand;
import ru.atkachev.TaskManager.command.task.TaskCreateCommand;
import ru.atkachev.TaskManager.command.task.TaskDeleteCommand;
import ru.atkachev.TaskManager.command.task.TaskPrintCommand;
import ru.atkachev.TaskManager.command.task.TaskUpdateCommand;
import ru.atkachev.TaskManager.repository.ProjectRepository;
import ru.atkachev.TaskManager.repository.TaskRepository;
import ru.atkachev.TaskManager.service.ProjectService;
import ru.atkachev.TaskManager.service.TaskService;
import ru.atkachev.TaskManager.api.IServiceLocate;

import java.util.*;

public class Bootstrap implements IServiceLocate {

    final private TaskRepository taskRepository = new TaskRepository();
    final private ProjectRepository projectRepository = new ProjectRepository();

    final private TaskService taskService = new TaskService(taskRepository);
    final private ProjectService projectService = new ProjectService(projectRepository, taskRepository);

    final private Scanner scanner = new Scanner(System.in);

    private final Map <String, AbstractCommand> commands = new HashMap<>();


    public void init(){
        String inputText;
        AbstractCommand tempObj;

        registry(new ProjectCreateCommand(this));
        registry(new ProjectPrintCommand(this));
        registry(new ProjectDeleteCommand(this));
        registry(new ProjectUpdateCommand(this));

        registry(new TaskCreateCommand(this));
        registry(new TaskPrintCommand(this));
        registry(new TaskDeleteCommand(this));
        registry(new TaskUpdateCommand(this));

        registry(new HelpCommand(this));
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

    // складывает в Мапу команды и объекты команд
    private void registry(AbstractCommand abstractCommand){
        commands.put(abstractCommand.command(), abstractCommand);
    }

    public Map <String, AbstractCommand> getCommandList(){
            return commands;
    }
    public ProjectService getProjectService(){
        return projectService;
    }
    public TaskService getTaskService(){
        return taskService;
    }
}
