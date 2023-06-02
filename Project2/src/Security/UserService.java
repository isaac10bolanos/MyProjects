package Security;

import UserService.User;

public interface UserService {
    User findByUsername(String username);
    void save(User user);
}
