package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CachedAnalyticsTest {

    private class MockExamination implements Examination{
        private int calls = 0;

        @Override
        public void addScore(AssessmentRecord assessmentRecord) {

        }

        @Override
        public AssessmentRecord getScore(String fullName, String subject) throws ItemNotFoundException {
            return null;
        }

        @Override
        public void addAllScores(List<AssessmentRecord> scores) {

        }

        @Override
        public double getAverageForSubject(String subject) {
            calls++;


            return calls;
        }

        @Override
        public Set<FullNameAndSubject> multipleSubmissionsStudentNames() {
            return Set.of();
        }

        @Override
        public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {
            return Set.of();
        }

        @Override
        public Collection<AssessmentRecord> getAllScores() {
            return List.of();
        }
    }


    private final MockExamination mock = new MockExamination();

    @Test
    void usingCache() {
        CachedAnalytics cached = new CachedAnalytics(mock);

        double firstCall = cached.getAverageForSubject("math");
        double secondCall = cached.getAverageForSubject("math");
        Assertions.assertEquals(1, mock.calls);
        Assertions.assertEquals(firstCall, secondCall);
        double thirdCall = cached.getAverageForSubject("geology");
        Assertions.assertEquals(2, mock.calls);

    }
    @Test
    void correctAverageFromCache() {

        CachedAnalytics cached = new CachedAnalytics(new ExaminationImpl());

        AssessmentRecord geol1 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 2);
        AssessmentRecord geol2 = new AssessmentRecord("Ivan Ivanov", "geology", 4);
        cached.addScore(geol1);
        cached.addScore(geol2);
        double firstAverage = cached.getAverageForSubject("geology");
        Assertions.assertEquals(3, firstAverage);
        AssessmentRecord geol3 = new AssessmentRecord("Viktor Viktorov", "geology", 6);
        cached.addScore(geol3);

        double secondAverage = cached.getAverageForSubject("geology");
        Assertions.assertEquals(4, secondAverage);

    }

}