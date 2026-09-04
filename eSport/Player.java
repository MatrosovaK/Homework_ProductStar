package org.eSport;

import java.util.Comparator;
import java.util.Objects;

public class Player implements Comparable<Player>{
    private final int id;
    private String name;
    private int rating;


    public Player(int id, String name, int rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Player other = (Player) object;
        return Objects.equals(name, other.name) && id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(Player o) {
        return Comparator.comparingInt((Player x) ->x.rating).reversed()
                .thenComparing(Comparator.comparing((Player x)->x.name,
                        Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))).compare(this, o);


    }

    @Override
    public String toString() {
        return name + " - " +  rating;
    }
}
