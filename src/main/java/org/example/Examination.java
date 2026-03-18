package org.example;

import java.util.Collection;
import java.util.List;
import java.util.Set;

record FullNameAndSubject(String fullName, String subject){}


public interface Examination {
    void addScore(AssessmentRecord assessmentRecord);

    AssessmentRecord getScore(String fullName, String subject) throws ItemNotFoundException;

    void addAllScores(List<AssessmentRecord> scores); //чтобы было проще добавлять все сразу

    double getAverageForSubject(String subject);

    Set<FullNameAndSubject> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Collection<AssessmentRecord> getAllScores();
}
