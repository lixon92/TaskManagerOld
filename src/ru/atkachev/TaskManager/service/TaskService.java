package ru.atkachev.TaskManager.service;

import ru.atkachev.TaskManager.entity.Task;
import ru.atkachev.TaskManager.repository.TaskRepository;

import java.util.List;

public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void createTask(String projectId, String name, String description) {
        taskRepository.createTask(projectId, name, description);
    }

    public void deleteTask(int index) {
        taskRepository.deleteTask(index);
    }

    public void updateTask(int index, String name, String description){
        taskRepository.updateTask(index, name, description);
    }

    public List<Task> getTaskList() {
        return taskRepository.getTaskList();
    }
}
