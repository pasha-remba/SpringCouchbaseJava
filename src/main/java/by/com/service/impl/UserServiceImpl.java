package by.com.service.impl;

import by.com.model.User;
import by.com.repository.UserRepository;
import by.com.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Qualifier("UserServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User findOne(String id) {
        return userRepository.findOne(id);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        Iterator<User> iterator = userRepository.findAll().iterator();
        while(iterator.hasNext()){
            users.add(iterator.next());
        }
        return users;
    }

    public List<User> findByFirstName(String firstName) {
        return userRepository.findByLastname(firstName);
    }

    public void create(User user) {
        user.setCreated(DateTime.now());
        userRepository.save(user);
    }

    public void update(User user) {
        user.setUpdated(DateTime.now());
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
