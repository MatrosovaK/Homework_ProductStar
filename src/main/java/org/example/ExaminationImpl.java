package org.example;

import java.util.*;

public class ExaminationImpl implements Examination{

    private final Map<FullNameAndSubject, Integer> journal = new HashMap<>();
    private  final Set<FullNameAndSubject> multipleSubmissionsStudentNames = new HashSet<>();
    public static final int CAPACITY = 5;
    private final Set<String>lastFiveStudentsWithExcellentMarkOnAnySubject = new HashSet<>(CAPACITY);

    @Override
    public void addScore(AssessmentRecord assessmentRecord) {
        FullNameAndSubject key = new FullNameAndSubject(assessmentRecord.fullName(), assessmentRecord.subject());
        if (journal.containsKey(key)){
            multipleSubmissionsStudentNames.add(key);
        }
        journal.put(key, assessmentRecord.score());
    }

    @Override
    public AssessmentRecord getScore(String fullName, String subject) throws ItemNotFoundException {
        FullNameAndSubject key = new FullNameAndSubject(fullName, subject);
        Integer score = journal.get(key);
        if(score == null){
            throw new ItemNotFoundException(key);
        }
        return new AssessmentRecord(fullName, subject, score);
    }

    @Override
    public void addAllScores(List<AssessmentRecord>listOfRecords) {
        for (AssessmentRecord record:listOfRecords) {
            FullNameAndSubject key = new FullNameAndSubject(record.fullName(), record.subject());

            if (journal.containsKey(key)){
                multipleSubmissionsStudentNames.add(key);
            }


            if(record.score() == 5){
                lastFiveStudentsWithExcellentMarkOnAnySubject.add(key.fullName());
            }
            journal.put(key, record.score());
        }

    }

    @Override
    public double getAverageForSubject(String subject) {
        Double average;
        int counter = 0;
        int sum = 0;
        for (FullNameAndSubject key : journal.keySet()) {

            int score = journal.get(key);
            if (key.subject().equals(subject)) {
                counter++;
                sum = sum + score;
            }
        }

        if(counter ==0){
            return 0;
        }

        average = (double) sum / counter;

        return average;

    }

    @Override
    public Set<FullNameAndSubject> multipleSubmissionsStudentNames() {
        return multipleSubmissionsStudentNames;
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        return lastFiveStudentsWithExcellentMarkOnAnySubject;
    }

    @Override
    public Collection<AssessmentRecord> getAllScores() {
        List<AssessmentRecord>allScores = new ArrayList<>();
        for(Map.Entry<FullNameAndSubject, Integer> entry : journal.entrySet()){
            FullNameAndSubject key = entry.getKey();
            allScores.add(new AssessmentRecord(key.fullName(), key.subject(), entry.getValue()));
        }


        return allScores;
    }
}
