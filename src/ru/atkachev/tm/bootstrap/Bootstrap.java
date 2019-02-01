package ru.atkachev.tm.bootstrap;

import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.command.helper.HelpCommand;
import ru.atkachev.tm.command.helper.Helper;
import ru.atkachev.tm.command.project.ProjectCreateCommand;
import ru.atkachev.tm.command.project.ProjectDeleteCommand;
import ru.atkachev.tm.command.project.ProjectPrintCommand;
import ru.atkachev.tm.command.project.ProjectUpdateCommand;
import ru.atkachev.tm.command.task.TaskCreateCommand;
import ru.atkachev.tm.command.task.TaskDeleteCommand;
import ru.atkachev.tm.command.task.TaskPrintCommand;
import ru.atkachev.tm.command.task.TaskUpdateCommand;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.service.ProjectService;
import ru.atkachev.tm.service.TaskService;
import ru.atkachev.tm.api.IServiceLocate;

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
    public String getTerminalService(){
        return scanner.nextLine();
    }
}
