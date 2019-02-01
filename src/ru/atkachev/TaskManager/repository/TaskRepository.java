package ru.atkachev.TaskManager.repository;

import ru.atkachev.TaskManager.entity.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private List<Task> taskList = new ArrayList<Task>();

    public void createTask(String projectId, String name, String description){
        Task task = new Task();

        task.setProjectId(projectId);
        task.setName(name);
        task.setDescribe(description);
        taskList.add(task);
    }

    public void deleteTask(int index){
        taskList.remove(index);
    }

    public void updateTask(int index, String name, String description){
        Task task = taskList.get(index);
        task.setName(name);
        task.setDescribe(description);
    }
    public List<Task> getTaskList() {
        return taskList;
    }
}
