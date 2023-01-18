package user;

import java.util.UUID;

public class UserDAO {
    private static final User[] users = new User[]{
            new User("Denis", "Redford", 26, UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3")),
            new User("Anna", "Nolan", 22, UUID.fromString("f6e65ae4-968f-11ed-a1eb-0242ac120002")),
            new User("Jack", "Kramdown", 56, UUID.fromString("0225bbac-9690-11ed-a1eb-0242ac120002"))};

    public UserDAO() {
    }

    public User[] getUsers() {
        return users;
    }
}
