package example.BookingCars.com.example.BookingCars.user;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserService {
    private UserFakerDataAccessService userArrayDataAccessService;
    public UserService(UserFakerDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService = userArrayDataAccessService;
    }

    public User findUser(UUID id) {
        for (User user : seeUsers()) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    public List<User> seeUsers() {
        return this.userArrayDataAccessService.getUsers();
    }
}

