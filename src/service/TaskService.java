package service;

import entity.Task;
import repository.TaskRepository;

import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void createTask(String name, String description) {
        taskRepository.createTask(name, description);
    }

    public void deleteTask(int index) {
        taskRepository.deleteTask(index);
    }

    public List<Task> getTaskList() {
        return taskRepository.getTaskList();
    }
}
