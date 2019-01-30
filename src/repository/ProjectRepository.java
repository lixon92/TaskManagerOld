package repository;

import entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    private List<Project> projectList = new ArrayList<Project>();

    public void createProject(String name, String description){
        Project project = new Project();
        project.setName(name);
        project.setDescribe(description);
        projectList.add(project);
    }

    public void createProject(String name){
        Project project = new Project();
        project.setName(name);
        projectList.add(project);
    }

    public void deleteProject(int index){
        projectList.remove(index);
    }

    public List<Project> getProjectList() {
        return projectList;
    }
}
