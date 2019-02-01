package ru.atkachev.tm.command.task;

import ru.atkachev.tm.api.IServiceLocate;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.entity.Task;

import java.util.List;

public class TaskPrintCommand  extends AbstractCommand {

    public TaskPrintCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "t p";
    }

    public void execute() {
        List<Task> taskList = serviceLocate.getTaskService().getTaskList();
        int index = 0;
        for (Task task : taskList){
            System.out.printf("%s. %s %.8s %.8s%n", index + 1, task.getName(), task.getId(), task.getProjectId());
            index++;
        }
    }

    public String description() {
        return "Print tasks";
    }
}
