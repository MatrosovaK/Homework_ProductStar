package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ExaminationImplTest {
    private Examination examination;

    @BeforeEach
    void setUp() {
        examination = new ExaminationImpl();
    }

    @org.junit.jupiter.api.Test
    void addAndGetRecord() throws ItemNotFoundException {

        AssessmentRecord geol1 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 5);
        AssessmentRecord geol2 = new AssessmentRecord("Ivan Ivanov", "geology", 2);
        AssessmentRecord geol3 = new AssessmentRecord("Viktor Viktorov", "geology", 5);
        AssessmentRecord hist1 = new AssessmentRecord("Vasiliy Vasiljev", "history", 5);
        AssessmentRecord hist2 = new AssessmentRecord("Ivan Ivanov", "history", 4);
        AssessmentRecord hist3 = new AssessmentRecord("Viktor Viktorov", "history", 5);
        AssessmentRecord geol4 = new AssessmentRecord("Ivan Ivanov", "geology", 4);
        examination.addScore(geol1);
        examination.addScore(geol2);
        examination.addScore(geol3);
        examination.addScore(hist1);
        examination.addScore(hist2);
        examination.addScore(hist3);
        examination.addScore(geol4);

        AssessmentRecord record = examination.getScore("Ivan Ivanov", "geology");
        AssessmentRecord expected = new AssessmentRecord("Ivan Ivanov", "geology", 4);
        Assertions.assertEquals(expected, record);

    }

    @org.junit.jupiter.api.Test
    void getScore() {
        Assertions.assertThrows(ItemNotFoundException.class, ()-> examination.getScore("Petya", "maths"));
    }

    @Test
    void addAllScores() throws ItemNotFoundException {

        AssessmentRecord geol1 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 3);
        AssessmentRecord geol2 = new AssessmentRecord("Ivan Ivanov", "geology", 2);
        AssessmentRecord geol3 = new AssessmentRecord("Viktor Viktorov", "geology", 5);
        AssessmentRecord hist1 = new AssessmentRecord("Vasiliy Vasiljev", "history", 5);
        AssessmentRecord hist2 = new AssessmentRecord("Ivan Ivanov", "history", 4);
        AssessmentRecord hist3 = new AssessmentRecord("Viktor Viktorov", "history", 5);
        AssessmentRecord geol4 = new AssessmentRecord("Ivan Ivanov", "geology", 4);
        AssessmentRecord geol5 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 5);
        examination.addAllScores(List.of(geol1, geol2, geol3, hist1, hist2, hist3, geol4, geol5));

        AssessmentRecord record1 = examination.getScore("Ivan Ivanov", "geology");
        AssessmentRecord expected1 = new AssessmentRecord("Ivan Ivanov", "geology", 4);
        Assertions.assertEquals(expected1, record1);

        AssessmentRecord record2 = examination.getScore("Vasiliy Vasiljev", "geology");
        AssessmentRecord expected2 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 5);
        Assertions.assertEquals(expected2, record2);

        //тут еще проверить размер мар

    }


    @org.junit.jupiter.api.Test
    void getAverageForSubject() {

        AssessmentRecord geol1 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 3);
        AssessmentRecord geol2 = new AssessmentRecord("Ivan Ivanov", "geology", 2);
        AssessmentRecord pe1 = new AssessmentRecord("Vasiliy Vasiljev", "physical education", 5);
        AssessmentRecord pe2 = new AssessmentRecord("Ivan Ivanov", "physical education", 2);
        AssessmentRecord pe3 = new AssessmentRecord("Ivan Ivanov", "physical education", 5);
        AssessmentRecord geol3 = new AssessmentRecord("Viktor Viktorov", "geology", 5);
        AssessmentRecord hist1 = new AssessmentRecord("Vasiliy Vasiljev", "history", 4);
        AssessmentRecord hist2 = new AssessmentRecord("Ivan Ivanov", "history", 4);
        AssessmentRecord pe4 = new AssessmentRecord("Viktor Viktorov", "physical education", 5);
        AssessmentRecord hist3 = new AssessmentRecord("Viktor Viktorov", "history", 5);
        AssessmentRecord geol4 = new AssessmentRecord("Ivan Ivanov", "geology", 4);
        AssessmentRecord geol5 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 5);
        AssessmentRecord geol6 = new AssessmentRecord("Petya Petrov", "geology", 4);
        AssessmentRecord hist4 = new AssessmentRecord("Petya Petrov", "history", 5);
        examination.addAllScores(List.of(geol1, geol2, pe1, pe2,pe3, geol3, hist1, hist2, pe4, hist3, geol4, geol5, geol6, hist4));
        Double averageForPE = examination.getAverageForSubject("physical education");
        Assertions.assertEquals(5, averageForPE);

        Double averageForGeol = examination.getAverageForSubject("geology");
        Assertions.assertEquals(4.5, averageForGeol);

        Double averageForHistory = examination.getAverageForSubject("history");
        Assertions.assertEquals(4.5, averageForHistory);

    }

    @org.junit.jupiter.api.Test
    void multipleSubmissionsStudentNames() {
        AssessmentRecord geol1 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 3);
        AssessmentRecord geol2 = new AssessmentRecord("Ivan Ivanov", "geology", 2);
        AssessmentRecord geol3 = new AssessmentRecord("Viktor Viktorov", "geology", 5);
        AssessmentRecord hist1 = new AssessmentRecord("Vasiliy Vasiljev", "history", 5);
        AssessmentRecord hist2 = new AssessmentRecord("Ivan Ivanov", "history", 4);
        AssessmentRecord hist3 = new AssessmentRecord("Viktor Viktorov", "history", 5);
        AssessmentRecord geol4 = new AssessmentRecord("Ivan Ivanov", "geology", 4);
        AssessmentRecord geol5 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 5);
        AssessmentRecord hist4 = new AssessmentRecord("Ivan Ivanov", "history", 5);
        AssessmentRecord hist5 = new AssessmentRecord("Petya Petrov", "history", 5);
        examination.addAllScores(List.of(geol1, geol2, geol3, hist1, hist2, hist3, geol4, geol5, hist4, hist5));

        Set<FullNameAndSubject> actual = examination.multipleSubmissionsStudentNames();
        Assertions.assertEquals(3, actual.size());


    }

    @org.junit.jupiter.api.Test
    void lastFiveStudentsWithExcellentMarkOnAnySubject() {
        AssessmentRecord geol1 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 3);
        AssessmentRecord geol2 = new AssessmentRecord("Ivan Ivanov", "geology", 5);
        AssessmentRecord geol3 = new AssessmentRecord("Viktor Viktorov", "geology", 5);
        AssessmentRecord hist1 = new AssessmentRecord("Vasiliy Vasiljev", "history", 5);
        AssessmentRecord hist2 = new AssessmentRecord("Ivan Ivanov", "history", 5);
        AssessmentRecord math1 = new AssessmentRecord("Dmitry Dmitriev", "math", 5);
        AssessmentRecord hist3 = new AssessmentRecord("Viktor Viktorov", "history", 5);
        AssessmentRecord geol4 = new AssessmentRecord("Ivan Ivanov", "geology", 5);
        AssessmentRecord geol5 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 5);
        AssessmentRecord hist4 = new AssessmentRecord("Ivan Ivanov", "history", 5);
        AssessmentRecord hist5 = new AssessmentRecord("Petya Petrov", "history", 5);

        examination.addAllScores(List.of(geol1, geol2, geol3, hist1, hist2, math1, hist3, geol4, geol5, hist4, hist5));

        Set<String> actual = examination.lastFiveStudentsWithExcellentMarkOnAnySubject();

        Set<String> expected = Set.of("Viktor Viktorov", "Ivan Ivanov", "Vasiliy Vasiljev", "Petya Petrov", "Dmitry Dmitriev");
        Assertions.assertEquals(expected, actual);



    }

    @org.junit.jupiter.api.Test
    void getAllScores() {
        AssessmentRecord geol1 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 3);
        AssessmentRecord geol2 = new AssessmentRecord("Ivan Ivanov", "geology", 5);
        AssessmentRecord geol3 = new AssessmentRecord("Viktor Viktorov", "geology", 5);
        AssessmentRecord hist1 = new AssessmentRecord("Vasiliy Vasiljev", "history", 5);
        AssessmentRecord hist2 = new AssessmentRecord("Ivan Ivanov", "history", 5);
        AssessmentRecord math1 = new AssessmentRecord("Dmitry Dmitriev", "math", 5);
        AssessmentRecord hist3 = new AssessmentRecord("Viktor Viktorov", "history", 5);
        AssessmentRecord geol4 = new AssessmentRecord("Ivan Ivanov", "geology", 5);
        AssessmentRecord geol5 = new AssessmentRecord("Vasiliy Vasiljev", "geology", 5);


        examination.addAllScores(List.of(geol1, geol2, geol3, hist1, hist2, math1, hist3, geol4, geol5));
        Collection<AssessmentRecord> actual = examination.getAllScores();
        Assertions.assertEquals(7, actual.size());
        //System.out.println(actual);


    }


}