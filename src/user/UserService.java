package user;

import java.awt.font.OpenType;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserService {
    private UserArrayDataAccessService userArrayDataAccessService;

    public UserService(UserArrayDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService = userArrayDataAccessService;
    }

    public User findUser(UUID id) {
//        for (User user : seeUsers()) {
//            if (user.getId().equals(id)) {
//                return user;
//            }
//        }
        return seeUsers().stream().filter(u -> u.getId().equals(id))
                .reduce((user1, user2) -> user1).get();
    }
    public List<User> seeUsers() {
        return this.userArrayDataAccessService.getUsers();
    }
}

