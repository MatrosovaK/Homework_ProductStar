package org.students;

import java.util.Map;

public class StudentCommandHandler {
    private StudentStorage studentStorage = new StudentStorage();


    public boolean processCommand(Command command){
        Action action = command.getAction();

        switch(action) {
            case CREATE -> {
                if (!processCreateCommand(command)) {
                    return false;
                }
            }
            case UPDATE -> {
                if(!processUpdateCommand(command)) {
                    return false;
                }
            }
            case DELETE -> {
                if(!processDeleteCommand(command)) {
                    return false;
                }
            }
            case STATS_BY_COURSE -> {
                if(!processStatsByCourseCommand(command)) {
                    return false;
                }
            }
            case STATS_BY_CITIES -> {
                if(!processStatsByCitiesCommand(command)) {
                    return false;
                }
            }

            case SEARCH -> {
                if(!processSearchCommand(command)) {
                    return false;
                }
            }


            default -> {
                System.out.println("Действие " + action + " не поддерживается");
                return false;

            }
        }

        System.out.println("Обработка команды. Действие: " + command.getAction().name() + ", данные: "
                + command.getData());
        return  true;

    }


    private boolean processSearchCommand(Command command){
        String data = command.getData();
//не пустая ли фамилия?
        if(data == null || data.isBlank()){
            studentStorage.printAll();
            return true;
        }

        String[] surnames = data.split(",");
//если одна фамилия
        if (surnames.length == 1) {
            studentStorage.searchOneStudent(surnames[0]);
        } else if (surnames.length == 2){
            studentStorage.searchRange(surnames[0], surnames[1]);
            return true;
        } else{
            System.out.println("Ошибка. Неправильный ввод");
            return false;
        }
        return true;

    }


    private boolean processStatsByCourseCommand(Command command){
        Map<String, Long> data = studentStorage.getCountByCourse();
        studentStorage.printMap(data);
        return true;
    }

    private boolean processStatsByCitiesCommand(Command command){
        Map<String, Long> data = studentStorage.getCountByCity();
        studentStorage.printMap(data);
        return true;
    }

    private boolean processCreateCommand(Command command){
        try {
            String data = command.getData();
            String[] dataArray = data.split(",");

            if (dataArray.length != 5) {
                System.out.println("Ошибка. Необходимо ввести 5 значений: Фамилия, Имя, Курс, Город, Возраст.");
                return false;
            }

            Student student = new Student();
            student.setSurname(dataArray[0]);
            student.setName(dataArray[1]);
            student.setCourse(dataArray[2]);
            student.setCity(dataArray[3]);
            student.setAge(Integer.valueOf(dataArray[4]));

            studentStorage.createStudent(student);
            studentStorage.printAll();
            return true;

        } catch(NumberFormatException e){
            System.out.println("Ошибка.Возраст должен быть числом!");
            return false;

        }

    }

    public boolean processUpdateCommand(Command command){

        String data = command.getData();
        String[] dataArray = data.split(",");

        // Проверяем, чтобы было 6 введенных данных
    if (dataArray.length != 6) {
        System.out.println("Ошибка. Необходимо ввести 6 значений: ID, Фамилия, Имя, Курс, Город, Возраст.");
        return false;
    }
        Long id;
    //Проверяем что ID - число
        try {
            id = Long.valueOf(dataArray[0]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка. ID не является числом");
            return false;
        }

        Integer age;
        try{
            age = Integer.valueOf(dataArray[5]);
        } catch(NumberFormatException e) {
            System.out.println("Ошибка. Введенный возраст не является числом");
            return false;
        }

        Student student=new Student();
        student.setSurname(dataArray[1]);
        student.setName(dataArray[2]);
        student.setCourse(dataArray[3]);
        student.setCity(dataArray[4]);
        student.setAge(age);

        studentStorage.updateStudent(id, student);

        //Проверяем обновился ли == есть ли такой студент
        boolean updated = studentStorage.updateStudent(id, student);
        if(!updated){
            System.out.println("Ошибка. Студент с ID " + id + " не найден.");

            return false;
        }

        studentStorage.printAll();
        return true;

}


    public boolean processDeleteCommand(Command command){
        try {
            String data = command.getData();
            Long id = Long.valueOf(data);
            boolean deleted = studentStorage.deleteStudent(id);
            if(!deleted){
                System.out.println("Ошибка. Студент с ID " + id + " не найден.");

                return false;
            }
            studentStorage.printAll();
            return true;

        }catch(NumberFormatException e){
            System.out.println("Ошибка. ID должно быть числом.");
            return false;
        }

    }
}
