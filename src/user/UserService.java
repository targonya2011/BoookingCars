package user;

import java.util.List;
import java.util.UUID;

public class UserService {
    private UserArrayDataAccessService userArrayDataAccessService;

    public UserService(UserArrayDataAccessService userArrayDataAccessService) {
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

