package org.coworking;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class CoworkingSystem {

TreeSet<Workspace>allWorkspaces = new TreeSet<>();
TreeMap<User, TreeSet<Workspace>>bookingManagement = new TreeMap<>();
List<User>allUsers = new ArrayList<>();



    public void addWorkspace(Workspace workspace){
        allWorkspaces.add(workspace);
        workspace.markAsAvailable();
        System.out.println("Рабочее место номер " + workspace.getNumber() + " добавлено в систему. тип: " + workspace.getType());
    }

    public boolean removeWorkspace(Workspace workspace){
        if (!allWorkspaces.contains(workspace)) {
            System.out.println("\nРабочее место номер " + workspace.getNumber() + " не добавлено в систему");
            System.out.println("\nСписок доступных рабочих мест: " + showAvailability());
            return false;
        } else{
            allWorkspaces.remove(workspace);
            System.out.println("\nРабочее место номер " + workspace.getNumber() + " удалено из системы. тип: " + workspace.getType());
            System.out.println("\nСписок доступных рабочих мест: " + showAvailability());
            return true;

        }
    }

    public void registerNewUser(User user){
        allUsers.add(user);
        System.out.println("Зарегистрирован новый пользователь:" + user.getName() +" "+ user.getSurname() + "\n");
    }

    public boolean bookWorkspace(User user, Workspace workspace)
            throws WorkspaceNotAvailableException, UserNotRegisteredException{
        System.out.println("\nПользователь "+ user.getName() + " " + user.getSurname() +
                " пытается забронировать рабочее место " + workspace.getNumber());
        if(!allUsers.contains(user)){
            throw new UserNotRegisteredException("\nОШИБКА! Пользователь " + user.getName() + " " + user.getSurname() +
                    " не зарегистрирован в системе. Зарегистрируйтесь ");
        }


        if(!allWorkspaces.contains(workspace)) {

            throw new WorkspaceNotAvailableException("\nОШИБКА! Рабочее место " + workspace.getNumber() +
                    " не добавлено в систему. \nДоступные рабочие места:" + showAvailability());



        } else if(!workspace.isAvailable()){
            throw new WorkspaceNotAvailableException("\nОШИБКА! Рабочее место " + workspace.getNumber() +
                    " уже занято. Мб с другим рабочим местом вам улыбнется удача. \n\nСписок доступных рабочих мест:" + showAvailability());


        } else{
            workspace.markAsBooked();

            System.out.println("\nУСПЕШНЫЙ УСПЕХ! " + user.getName() + " " + user.getSurname() +
                    " забронировал рабочее место номер " + workspace.getNumber() + "\n");
            System.out.println("Список доступных рабочих мест: " + showAvailability());



            if(!bookingManagement.containsKey(user)){
                bookingManagement.put(user, new TreeSet<>());
            }
            bookingManagement.get(user).add(workspace);
            return true;
        }
    }

    public boolean cancelBooking (User user, Workspace workspace){
        TreeSet<Workspace>userWorkspaces = bookingManagement.get(user);

        if(userWorkspaces != null && userWorkspaces.contains(workspace)){
            workspace.markAsAvailable();
            userWorkspaces.remove(workspace);
            bookingManagement.get(user).remove(workspace);
            System.out.println("\nПользователь " + user.getName() + " " +user.getSurname() +  " отменил бронирование рабочего места номер " + workspace.getNumber());
            System.out.println("\nСписок доступных рабочих мест: " + showAvailability());

            return true;

        } else {
            System.out.println("\nПользователь " + user.getName() + " " +user.getSurname() + " пытается отменить бронирование" +
                    " рабочего места номер " + workspace.getNumber());
            System.out.println("Ошибка. У пользователя нет такого бронирования");

            return false;
        }
    }

    public String showAvailability(){

        StringBuilder sb = new StringBuilder();
        int counter = 1;

        for(Workspace w:allWorkspaces){
            if(w.isAvailable()){
                if(counter > 1){
                    sb.append("\n");
                }

                sb.append(counter).append(". номер ").append(w.getNumber()).append(". Тип: ").append(w.getType());
                counter++;

            }
        }


        String availablePlacesText;
        if (counter == 1) {
            availablePlacesText = "\nК сожалению, сейчас нет ни одного свободного рабочего места.";
        } else {
            availablePlacesText = "\n" + sb.toString();
        }
        return availablePlacesText;

    }

}




