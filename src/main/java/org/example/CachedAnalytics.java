package org.example;

import java.util.*;

public class CachedAnalytics implements Examination{
    private final Map<String, Double> cache = new LRUCache(5);
    private final Examination examination;

    public CachedAnalytics(Examination examination) {
        this.examination = examination;
    }

    @Override
    public void addScore(AssessmentRecord assessmentRecord) {
        examination.addScore(assessmentRecord);
        cache.clear();
    }

    @Override
    public AssessmentRecord getScore(String fullName, String subject) throws ItemNotFoundException {
        return examination.getScore(fullName, subject);
    }

    @Override
    public void addAllScores(List<AssessmentRecord> scores) {
        examination.addAllScores(scores);
        cache.clear();
    }

    @Override
    public double getAverageForSubject(String subject) {
        if(cache.containsKey(subject)){
            return cache.get(subject);
        }
        double average = examination.getAverageForSubject(subject);
        cache.put(subject, average);

        return average;
    }

    @Override
    public Set<FullNameAndSubject> multipleSubmissionsStudentNames() {
        return examination.multipleSubmissionsStudentNames();
    }

    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
        return examination.lastFiveStudentsWithExcellentMarkOnAnySubject();
    }

    @Override
    public Collection<AssessmentRecord> getAllScores() {
        return examination.getAllScores();
    }


}


class LRUCache<KEY, VALUE> extends LinkedHashMap<KEY,VALUE> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<KEY, VALUE> eldest) {
        return size() > capacity;
    }
}