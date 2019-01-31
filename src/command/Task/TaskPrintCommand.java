package command.Task;

import api.IServiceLocate;
import command.AbstractCommand;
import entity.Task;

import java.util.List;

public class TaskPrintCommand  extends AbstractCommand {
    public TaskPrintCommand(IServiceLocate serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "td";
    }

    public void execute() {
        List<Task> taskList = serviceLocate.getTaskService().getTaskList();
        int index = 0;
        for (Task task : taskList){
            System.out.println(index + 1 + ". " + task.getName() + " " + task.getId());
            index++;
        }
    }

    public String description() {
        return "Print tasks";
    }
}
