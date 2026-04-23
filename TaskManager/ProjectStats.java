package org.example.TaskManager;

import java.util.List;

public class ProjectStats {

    public static int countTasks(Project project) {
        if (project == null) {
            return 0;
        }
        return project.getAllTasks().size();
    }

    public static int countTasksByStatus(Project project, TaskStatus status) {
        int taskByStatus = 0;
        for (Task t : project.getAllTasks()) {
            if (t.getStatus() == status) {
                taskByStatus++;
            }
        }
        return taskByStatus;
    }

    public static int countAllTasks(List<Project> projects) {
        int count = 0;
        for (Project p : projects) {
            count += p.getAllTasks().size();
        }
        return count;
    }

    public static boolean isProjectCompleted(Project project) {
        for (Task t : project.getAllTasks()) {
            if (!t.isDone()) {
                return false;
            }
        }
        return true;
    }
}


