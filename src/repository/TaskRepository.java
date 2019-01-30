package repository;

import entity.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> taskList = new ArrayList<Task>();

    public void createTask(String name, String description){
        Task task = new Task();
        task.setName(name);
        task.setDescribe(description);
        taskList.add(task);
    }

    public void createTask(String nameTask){
        Task task = new Task();
        task.setName(nameTask);
        taskList.add(task);
    }

    public List<Task> getTaskList() {
        return taskList;
    }
}
