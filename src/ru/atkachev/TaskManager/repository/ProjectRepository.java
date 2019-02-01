package ru.atkachev.TaskManager.repository;

import ru.atkachev.TaskManager.entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    final private List<Project> projectList = new ArrayList<>();
    private Project project = new Project();

    public void createProject(String name, String description){
        project.setName(name);
        project.setDescribe(description);
        projectList.add(project);
    }

    public void deleteProject(int index){
        projectList.remove(index);
    }

    public void updateProject( int index, String name, String description ){
        project = projectList.get(index);
        project.setName(name);
        project.setDescribe(description);
    }

    public List<Project> getProjectList() {
        return projectList;
    }
}
