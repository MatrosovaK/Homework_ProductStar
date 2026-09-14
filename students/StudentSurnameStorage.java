package org.students;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentSurnameStorage {

    private TreeMap<String, Set<Long>> surnamesTreeMap = new TreeMap<>();

    public void studentCreated(Long id, String surname){
        Set<Long>existingIDs = surnamesTreeMap.getOrDefault(surname, new HashSet<>());
        existingIDs.add(id);
        surnamesTreeMap.put(surname, existingIDs);

    }


    public void studentDeleted(Long id, String surname){
        surnamesTreeMap.get(surname).remove(id);
    }

    public void studentUpdated(Long id, String oldSurname, String newSurname){
        studentDeleted(id, oldSurname);
        studentCreated(id, newSurname);

    }

    public Set<Long> getStudentsBySurname(String surname){
        return surnamesTreeMap.getOrDefault(surname, Collections.emptySet());
    }


    public Set<Long> getSurnamesRange(String surname1, String surname2) {

        if (surname1.compareTo(surname2) > 0) {
            String temp = surname1;
            surname1 = surname2;
            surname2 = temp;
        }

        Set<Long> res = surnamesTreeMap.subMap(surname1, true, surname2, true)
                .values()
                .stream()
                .flatMap(longs -> longs.stream())
                .collect(Collectors.toSet());
        return res;
    }

    public boolean containsSurname(String surname) {
        return surnamesTreeMap.containsKey(surname);
    }

    }


