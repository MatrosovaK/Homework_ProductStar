package org.coworking;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws WorkspaceNotAvailableException, UserNotRegisteredException {

        CoworkingSystem coworking = new CoworkingSystem();

        User u1 = new User("Ваня", "Иванов");
        User u2 = new User("Петя", "Петров");
        User u3 = new User("Вася", "Васильев");

        coworking.registerNewUser(u1);
        coworking.registerNewUser(u2);


        Workspace no1 = new Workspace(1, WorkspaceType.STANDARD);
        coworking.addWorkspace(no1);

        Workspace no2 = new Workspace(2, WorkspaceType.MEETING_ROOM);
        coworking.addWorkspace(no2);

        Workspace no3 = new Workspace(3, WorkspaceType.LUNCH_ROOM);
        coworking.addWorkspace(no3);

        Workspace no4 = new Workspace(4, WorkspaceType.VIP);
        coworking.addWorkspace(no4);

        Workspace no5 = new Workspace(5, WorkspaceType.STANDARD);
        coworking.addWorkspace(no5);

        Workspace no10 = new Workspace(10, WorkspaceType.STANDARD);

        try {
            coworking.bookWorkspace(u3, no1);

            } catch(UserNotRegisteredException | WorkspaceNotAvailableException e){
            System.out.println(e.getMessage());
        }


        try {
            coworking.bookWorkspace(u1, no1);
        } catch(UserNotRegisteredException | WorkspaceNotAvailableException e){
            System.out.println(e.getMessage());
        }


        try {
            coworking.bookWorkspace(u1, no2);
        } catch(UserNotRegisteredException | WorkspaceNotAvailableException e){
            System.out.println(e.getMessage());
        }

        try {
            coworking.bookWorkspace(u2, no2);
        } catch(UserNotRegisteredException | WorkspaceNotAvailableException e){
            System.out.println(e.getMessage());
        }

        try {
            coworking.bookWorkspace(u2, no3);
        } catch(UserNotRegisteredException | WorkspaceNotAvailableException e){
            System.out.println(e.getMessage());
        }


        try {
            coworking.bookWorkspace(u2, no10);
        } catch(UserNotRegisteredException | WorkspaceNotAvailableException e){
            System.out.println(e.getMessage());
        }

        try {
            coworking.bookWorkspace(u1, no4);
        } catch(UserNotRegisteredException | WorkspaceNotAvailableException e){
            System.out.println(e.getMessage());
        }

    coworking.removeWorkspace(no5);
    coworking.removeWorkspace(no10);


    coworking.cancelBooking(u2, no3);
    coworking.cancelBooking(u2, no5);

    }
}