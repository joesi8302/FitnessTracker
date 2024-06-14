package com.synergisticit.service;

import com.synergisticit.model.User;
import com.synergisticit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    User findById(long id);
    List<User> findAll();
    User saveUser(User user);
    User updateUser(User user);
    void deleteUserById(long id);



}
