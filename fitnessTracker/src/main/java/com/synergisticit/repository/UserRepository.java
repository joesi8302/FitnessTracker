package com.synergisticit.repository;


import com.synergisticit.model.User;

import java.util.List;

public interface UserRepository{

    User findById(long id);
    List<User> findAll();
    User saveUser(User user);
    User updateUser(User user);
    void deleteUserById(long id);

}
