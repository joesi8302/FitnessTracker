package com.synergisticit.repository.Impl;

import com.synergisticit.model.User;
import com.synergisticit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public User findById(long id) {
        return mongoTemplate.findById(id, User.class);
    }

    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User saveUser(User user) {

        return mongoTemplate.save(user);
    }

    @Override
    public User updateUser(User user) {
        return mongoTemplate.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        User user = new User();
        user.setId(id);
        mongoTemplate.remove(user);
    }
}
