package org.NIOUsers;

public class ShowUsersCommand implements MenuCommand{
    private final UserManager userManager;

    public ShowUsersCommand(UserManager userManager) {
        this.userManager = userManager;
    }


    @Override
    public void execute() {
        System.out.println("Список пользователей: ");
        for(User user: userManager.getUsers()){
            System.out.println(user);
        }
    }
}
