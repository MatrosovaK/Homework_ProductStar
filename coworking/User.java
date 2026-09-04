package org.coworking;

import java.util.Objects;
import java.util.TreeSet;
import java.util.UUID;

public class User implements Comparable<User>{
    private final String name;
    private final String surname;
    private final UUID id;

    public User(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    private final TreeSet<Workspace> bookedRooms = new TreeSet<>();

    boolean bookWorkspace(Workspace workspace){
        if(!workspace.isAvailable()){
            return false;
        } else{
            workspace.markAsBooked();
            bookedRooms.add(workspace);
            return true;
        }
    }


    boolean cancelBooking(Workspace workspace) {
        if (!bookedRooms.contains(workspace)) {
            return false;
        } else {
            bookedRooms.remove(workspace);
            workspace.markAsAvailable();
            return true;

        }
    }

    @Override
    public int compareTo(User o) {
        if(surname.equals(o.surname)){
            return name.compareTo(o.name);
        } else{
            return surname.compareTo(o.surname);
        }

    }


    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }

        if(object == null || getClass() != object.getClass()){
            return false;
        }

        User other = (User) object;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
