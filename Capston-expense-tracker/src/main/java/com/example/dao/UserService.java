package com.example.dao;

import com.example.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User getUserByName(String name);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
	User getUserByEmail(String email);
}
