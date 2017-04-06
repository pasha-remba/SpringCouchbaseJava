package by.com.service;

import by.com.model.User;

import java.util.List;

public interface UserService {

    User findOne(String id);
    List<User> findAll();
    List<User> findByFirstName(String firstName);

    void create(User user);
    void update(User user);
    void delete(User user);

}
