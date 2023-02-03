package user;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFakerDataAccessService implements UserDAO {
    public UserFakerDataAccessService() {
    }
    public List<User> generateUsers() {
        Faker faker = new Faker();
        List<User> users = new ArrayList<>();
        int count = 20;
        for (int i = 0; i < count; i++) {
            users.add(new User(faker.name().firstName(),
                    faker.name().lastName(),
                    faker.number().numberBetween(18, 90),
                    UUID.randomUUID()));
        }
        return users;
    }
    @Override
    public List<User> getUsers() {
        return generateUsers();
    }
}
