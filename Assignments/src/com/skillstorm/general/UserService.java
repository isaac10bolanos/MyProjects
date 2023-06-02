package com.skillstorm.general;


public interface UserService {
    User findByUsername(String username);
    void save(User user);
}
