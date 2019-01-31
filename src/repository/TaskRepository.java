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

    public void deleteTask(int index){
        taskList.remove(index);
    }

    public List<Task> getTaskList() {
        return taskList;
    }
}
