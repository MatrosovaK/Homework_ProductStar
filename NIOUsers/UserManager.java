package org.NIOUsers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User>users = new ArrayList<>();
    private final Path filePath = Path.of("users.txt");

    public void loadFromFile() throws IOException{
        if(!Files.exists(filePath)) {
            return;
        }
        List<String>lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        for(String line:lines){
            String[]parts = line.split("\\s*,\\s*", 2);
            if(parts.length == 2){
                User user = new User(parts[0], parts[1]);
                users.add(user);
            }
        }

    }

    public void saveToFile(User user) throws IOException{
        String line = user.getName() + "," + user.getCity() + System.lineSeparator();

        Files.writeString(filePath, line, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

    }

    public void addUser(User user) throws IOException{
        users.add(user);
        saveToFile(user);
    }

    public List<User> getUsers() {
        return users;
    }
}



