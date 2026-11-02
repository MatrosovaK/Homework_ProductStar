package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public List<Student> readStudents(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                for(int i = 0; i <fields.length; i++){
                    fields[i] = fields[i].replace("\"", "");
                }

                Student student = new Student(
                        fields[0],
                        fields[1],
                        fields[2],
                        fields[3],
                        fields[4],
                        Integer.parseInt(fields[5]),
                        Integer.parseInt(fields[6]),
                        Integer.parseInt(fields[7])
                );
                students.add(student);
            }

        }
        return students;
    }
}

