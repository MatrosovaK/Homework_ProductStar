package org.detectiveGame;

import java.util.HashSet;
import java.util.Set;

public class EvidenceDatabase {

    private final Set<String> database = new HashSet<>();

    public EvidenceDatabase() {
        database.add("Отпечаток пальца на унитазе");
        database.add("След обуви на потолке");
        database.add("Разбитое зеркало");
        database.add("Кнопка от пальто");
        database.add("Костюм гуся");
        database.add("Тапок 48 размера");
        database.add("Фальшивые усы");
        database.add("Один носок с утками");

    }

    public Set<String> getDatabase() {
        return database;
    }

    public Set<String> databaseMatches(EvidenceData evidenceData){
        Set<String>coincidences = new HashSet<>(evidenceData.getEvidences());
        coincidences.retainAll(database);
        return coincidences;

    }

    public String getListOfCoincidences(EvidenceData evidenceData){
        StringBuilder sb = new StringBuilder();
        for(String coincidence:databaseMatches(evidenceData)){
            sb.append("\n - ").append(coincidence);
        }
        return sb.toString();
    }







}
