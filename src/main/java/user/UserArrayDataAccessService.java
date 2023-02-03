package user;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDAO {
    public List<User> users() {
        File file = new File(getClass().getClassLoader().getResource("users.csv").getPath());
        List<User> usersList = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] split = scanner.nextLine().split(",");
                usersList.add(new User(split[0],
                        split[1].trim(),
                        Integer.parseInt(split[2].trim()),
                        UUID.fromString(split[3].trim())));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public UserArrayDataAccessService() {
    }
    @Override
    public List<User> getUsers() {
        return users();
    }
}
