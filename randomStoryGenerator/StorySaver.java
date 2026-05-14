package org.randomStoryGenerator;

import java.util.ArrayList;

public class StorySaver {
    ArrayList<String> stories = new ArrayList<>();

    public void saveStory(String story){
        stories.add(story);

    }

    public String getListOfStories(){
        StringBuilder sb = new StringBuilder();

        int counter = 0;
        for (String story:stories){
            counter++;
            sb.append("\n").append(counter).append(") ").append(story);
        }
        return sb.toString();
    }
}
