package com.bdg.crudmvc.service;

import com.bdg.crudmvc.model.User;
import com.bdg.crudmvc.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();

        for (User user : iterable) {
            userList.add(user);
        }

        return userList;
    }

    public User getUser(int id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User updateUser(User user, int id) {
        user.setId(id);
        userRepository.save(user);

        return user;
    }

    public void deleteById(int id) {
        User user = getUser(id);

        if (user != null) {
            userRepository.deleteById(id);
        }
    }
}