package org.coworking;

public class Workspace implements Comparable<Workspace> {
     private int number;
     private WorkspaceType type;
     private boolean isAvailable;

    public Workspace(int number, WorkspaceType type) {
        this.number = number;
        this.type = type;
        this.isAvailable = isAvailable;
    }


    public int getNumber() {
        return number;
    }


    public WorkspaceType getType() {
        return type;
    }


    public boolean isAvailable() {
        return isAvailable;
    }


    @Override
    public int compareTo(Workspace o) {
        return Integer.compare(number, o.number);
    }

    public void markAsBooked(){
        isAvailable = false;
    }

    public void markAsAvailable(){
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Статус рабочего места (" + type + ") под номером "
                + number + (isAvailable ? ": доступно" : ": занято");

    }
}
