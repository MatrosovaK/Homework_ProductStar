package org.detectiveGame;

public record Evidence(String name) {

    @Override
    public String toString() {
        return name;
    }
}
