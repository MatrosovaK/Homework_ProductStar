package org.randomStoryGenerator;

import java.util.Random;

public class StoryGenerator {
    private final StoryData data;
    private final Random random = new Random();

    public StoryGenerator(StoryData data) {
        this.data = data;
    }

    public String getRandomCharacter(){
        return data.getCharacters().get(random.nextInt(data.getCharactersQuantity()));
    }

    public String getRandomAction(){
        return data.getActions().get(random.nextInt(data.getActionsQuantity()));
    }

    public String getRandomPlace(){
        return data.getPlaces().get(random.nextInt(data.getPlacesQuantity()));
    }

    public String generateRandomStory() {
        return getRandomCharacter() + " " +  getRandomAction() + " " + getRandomPlace();
    }


}
