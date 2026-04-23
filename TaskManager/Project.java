package org.example.TaskManager;

import java.util.List;
import java.util.Comparator;

public class Project implements Manageable{
    private String projectName;
    private List<Task>tasks;

    public Project(String projectName, List<Task> tasks) {
        this.projectName = projectName;
        this.tasks = tasks;
    }

    public String getProjectName() {
        return projectName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task){

        tasks.add(task);
    }

    public void deleteTask(Task task){
        tasks.remove(task);

    }

    public List<Task> getAllTasks(){
        return tasks;
    }

    @Override
    public void assign() {
        System.out.println("Проект " + projectName + " назначен");
        for (Task task:tasks){
            task.setStatus(TaskStatus.TODO);
        }
    }

    @Override
    public void start() {
        System.out.println("Проект " + projectName + " запущен");
        for (Task task:tasks){
            if(task.getStatus() == TaskStatus.TODO){
                task.setStatus(TaskStatus.IN_PROGRESS);
            }
        }
    }

    @Override
    public void complete() {
        for (Task task:tasks){
            task.setStatus(TaskStatus.DONE);
        }


        System.out.println("Проект " + projectName + " выполнен");
    }


    public static class TaskComparator implements Comparator<Task> {
        private final Comparator<Task> comparator;

        public TaskComparator(Comparator<Task> comparator) {
            this.comparator = comparator;
        }

        @Override
        public int compare(Task t1, Task t2) {
            return comparator.compare(t1, t2);
        }
    }
}
