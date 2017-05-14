package com.mcnaughton.bbc.service.impl;

import com.mcnaughton.bbc.domain.UserDao;
import com.mcnaughton.bbc.models.User;
import com.mcnaughton.bbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(String name) {
        return userDao.addUser(name);
    }

    @Override
    public User getUser(UUID id) {
        return userDao.getUser(id);
    }
}
