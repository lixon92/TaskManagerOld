package ru.atkachev.TaskManager.command.task;

import ru.atkachev.TaskManager.api.IServiceLocate;
import ru.atkachev.TaskManager.command.AbstractCommand;
import ru.atkachev.TaskManager.entity.Task;

import java.util.List;

public class TaskPrintCommand  extends AbstractCommand {
    final private List<Task> taskList = serviceLocate.getTaskService().getTaskList();
    private int index = 0;
    public TaskPrintCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "t p";
    }

    public void execute() {
        for (Task task : taskList){
            System.out.printf("%s. %s %.8s %.8s%n", index + 1, task.getName(), task.getId(), task.getProjectId());
            index++;
        }
    }

    public String description() {
        return "Print tasks";
    }
}
