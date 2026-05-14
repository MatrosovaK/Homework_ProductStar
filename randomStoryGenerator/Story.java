package org.randomStoryGenerator;

public class Story {

    private String character;
    private String action;
    private String place;

    public Story(String character, String action, String place) {
        this.character = character;
        this.action = action;
        this.place = place;
    }

    @Override
    public String toString() {
        return character + " " +  action + " " +  place ;
    }


}
