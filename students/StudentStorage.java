package org.students;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentStorage {

    //управление данными о студенте
    private StudentSurnameStorage studentSurnameStorage = new StudentSurnameStorage();
    private Map<Long, Student> studentStorageMap = new HashMap<>();
    private Long currentID = 0L;



    public Long createStudent(Student student){
        Long nextID = getNextID();
        studentStorageMap.put(nextID, student);
        studentSurnameStorage.studentCreated(nextID, student.getSurname());
        return nextID;
    }


    public boolean updateStudent(Long id, Student student){
        if(!studentStorageMap.containsKey(id)){
            return false;
        } else{
            String newSurname = student.getSurname();
            String oldSurname = studentStorageMap.get(id).getSurname();
            studentSurnameStorage.studentUpdated(id, oldSurname, newSurname);
            studentStorageMap.put(id, student);

            return true;
        }
    }

    public boolean deleteStudent(Long id){
        //true -если студент был удален, false- если студент не найден
        Student removed = studentStorageMap.remove(id);
        if(removed != null){
            String surname = removed.getSurname();
            studentSurnameStorage.studentDeleted(id, surname);
        }

        return removed != null;
    }

    public boolean searchOneStudent(String surname){
        Set<Long> students = studentSurnameStorage.getStudentsBySurname(surname);
        if(students.isEmpty()){
            System.out.println("Ошибка. Нет студентов с такой фамилией");
            return false;
        }
        for(Long studentID: students) {
            Student student = studentStorageMap.get(studentID);
            System.out.println(student);
        }

        return true;
    }


    public void searchRange(String surname1, String surname2) {
        Set<Long> students = studentSurnameStorage.getSurnamesRange(surname1, surname2);
        // Set<Long> students = studentSurnameStorage.getSurnamesLessOrEqualThan(surname);

        for (Long studentID: students){
            Student student = studentStorageMap.get(studentID);
            System.out.println(student);
        }

    }

    public boolean containsSurname(String surname) {
        return studentSurnameStorage.containsSurname(surname);
    }

    public Long getNextID(){
        currentID = currentID + 1;
        return currentID;
    }


    public void printAll(){
        System.out.println(studentStorageMap);
    }

    public void printMap(Map<String, Long> data) {

        //<имя курса, кол-во студ на каждом курсе>

        data.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + " - " + e.getValue());
        });
    }

    public Map<String, Long> getCountByCity(){
        Map<String, Long> res = studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        student-> student.getCity(),   //извлечение ключа
                        student -> 1L,
                        (count1, count2) -> count1 + count2 //то что в мап + 1
                ));
        return res;
    }



    public Map<String, Long> getCountByCourse() {
        Map<String, Long> res = studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        student -> student.getCourse(),   //извлечение ключа
                        student -> 1L,
                        (count1, count2) -> count1 + count2 //то что в мап + 1
                ));
        return res;
    }




}
