package user;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages user registration and authentication.
 */
public class UserService {
    private List<User> users = new ArrayList<>();

    // Register a new user
    public boolean register(String username, String password, String role) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return false; // username exists
            }
        }
        users.add(new User(users.size() + 1, username, password, role));
        return true;
    }

    // Authenticate a user
    public User authenticate(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
