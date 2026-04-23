package org.example.TaskManager;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Project> projects;

    public TaskManager() {
        this.projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        projects.add(project);
    }
    public void removeProject(Project project){
        projects.remove(project);
    }

    public void displayAllProjects() {
        for(Project project:projects){
            System.out.println(project);
        }
    }

    public Project findProjectByName(String name){
        for(Project project:projects){
            if(project.getProjectName().equals(name)){
                return project;
            }
        }
        return null;
    }

    public List<Task> getAllTasksFromAllProjects(){
        List<Task> allProjectsTasks = new ArrayList<>();
        for(Project project:projects){
            allProjectsTasks.addAll(project.getAllTasks());

        }
        return allProjectsTasks;
    }

    public List<Task> getTaskByStatus(TaskStatus status){
        List<Task>allTasksByStatus = new ArrayList<>();
        for (Project project:projects){
            for(Task t:project.getAllTasks()) {
                if (t.getStatus()== status) {
                    allTasksByStatus.add(t);
                }
            }
        }
        return allTasksByStatus;
    }


}
