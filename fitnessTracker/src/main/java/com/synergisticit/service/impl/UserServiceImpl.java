package com.synergisticit.service.impl;

import com.synergisticit.model.User;
import com.synergisticit.repository.UserRepository;
import com.synergisticit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        User foundUser = userRepository.findById(user.getId());
        if(foundUser == null){
            return null;
        }else{
            foundUser.setAge(user.getAge());
            foundUser.setName(user.getName());
            foundUser.setWeight(user.getWeight());
            userRepository.saveUser(foundUser);
            return foundUser;
        }

    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteUserById(id);
    }
}
