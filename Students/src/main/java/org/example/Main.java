package org.example;

import org.example.dao.StudentDao;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.createTable();

        if (DatabaseManager.getStudentsCount() == 0) {

            CsvReader csvReader = new CsvReader();

            List<Student> students = csvReader.readStudents(
                    "src/main/resources/StudentsPerformance.csv"
            );

            System.out.println("Прочитано студентов: " + students.size());

            StudentImporter importer = new StudentImporter();
            importer.importStudents(students);

            System.out.println("Импорт завершён!");

        } else {
            System.out.println("Данные уже есть в базе. Повторный импорт не требуется.");
        }

        System.out.println("Количество записей в БД: "
                + DatabaseManager.getStudentsCount());

        StudentDao studentDao = new org.example.dao.StudentDaoImpl();


        System.out.println("\n--- Все студенты ---");
        System.out.println("Количество: " + studentDao.findAll().size());


        System.out.println("\n--- Подготовительный курс ---");
        System.out.println("Количество: "
                + studentDao.findPreparedStudents().size());


        System.out.println("\n--- Math score > 80 ---");
        System.out.println("Количество: "
                + studentDao.findByMathScore(80).size());


        System.out.println("\n--- Female students ---");
        System.out.println("Количество: "
                + studentDao.findByGender("female").size());


        System.out.println("\n--- Group B ---");
        System.out.println("Количество: "
                + studentDao.findByRaceEthnicity("group B").size());



    }
}