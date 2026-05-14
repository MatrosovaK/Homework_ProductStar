package org.randomStoryGenerator;

import java.util.ArrayList;
import java.util.List;

public class StoryData {

    private List<String> characters = new ArrayList<>();
    private List<String>actions = new ArrayList<>();
    private List<String> places = new ArrayList<>();

    public void addCharacter(String character){
        characters.add(character);
    }

    public void addAction(String action) {
        actions.add(action);
    }

    public void addPlace(String place) {
        places.add(place);
    }

    public int getCharactersQuantity(){
        return characters.size();

    }

    public int getActionsQuantity(){
        return actions.size();

    }

    public int getPlacesQuantity(){
        return places.size();

    }

    public List<String> getCharacters() {
        return characters;
    }

    public List<String> getActions() {
        return actions;
    }

    public List<String> getPlaces() {
        return places;
    }
}
