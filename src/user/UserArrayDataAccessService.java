package user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDAO {
    public static User[] users() {
        String path = "D:\\Users\\Denis-skillbox\\Desktop\\BoookingCars\\resources\\users.csv";
        String out;
        BufferedReader br;
        String[] allLines;
        ArrayList<User> al = new ArrayList<>();
        try{
            br = new BufferedReader(new FileReader(path));
            while ((out = br.readLine()) != null) {
                allLines = out.split(",");
                for (int i = 0; i < allLines.length / 4; i++) {
                    al.add(new User(allLines[i],
                            allLines[i + 1].trim(),
                            Integer.parseInt(allLines[i + 2].trim()),
                            UUID.fromString(allLines[i + 3].trim())));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return al.toArray(new User[al.size()]);
    }

    public UserArrayDataAccessService() {
    }
    @Override
    public User[] getUsers() {
        return users();
    }
}
