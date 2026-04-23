package org.example.TaskManager;

import java.util.Date;

public class Task {
    private String title;
    private String description;
    private Date dueDate;
    private TaskStatus status;

    public Task(String title, String description, Date dueDate, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                '}';
    }


    public boolean isDone(){
        return status == TaskStatus.DONE;
    }

    public boolean isOverdue(){
        return new Date().after(dueDate) && status != TaskStatus.DONE;
    }
}
