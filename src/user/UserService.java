package user;

import java.util.List;
import java.util.UUID;

public class UserService {
    private UserArrayDataAccessService userArrayDataAccessService;

    public UserService(UserArrayDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService = userArrayDataAccessService;
    }

    public User findUser(UUID id) {
        User user = null;

        for (int i = 0; i < seeUsers().size(); i++) {
            if (this.seeUsers().get(i).getId().equals(id)) {
                user = this.seeUsers().get(i);
            }
            else {
                System.out.println(String.format("User with id %s not found", id));
            }
        }
        return user;
    }
    public List<User> seeUsers() {
        return this.userArrayDataAccessService.getUsers();
    }
}

