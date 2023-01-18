package user;

import java.util.UUID;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public UserService() {
    }

    public User findUser(UUID id) {
        User user = null;

        for(int i = 0; i < this.seeUsers().length; ++i) {
            if (this.seeUsers()[i].getId().equals(id)) {
                user = this.seeUsers()[i];
            }
        }

        return user;
    }

    public User[] seeUsers() {
        return this.userDAO.getUsers();
    }
}

