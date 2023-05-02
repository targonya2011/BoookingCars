package example.BookingCars.com.example.BookingCars.user;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFakerDataAccessService implements UserDAO {
    public UserFakerDataAccessService() {
        generateUsers();
    }
    private List<User> users;
    public void generateUsers() {
        Faker faker = new Faker();
        int count = 20;
        users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(new User(faker.name().firstName(),
                    faker.name().lastName(),
                    faker.number().numberBetween(18, 90),
                    UUID.randomUUID()));
        }
    }
    @Override
    public List<User> getUsers() {
        return users;
    }
}
