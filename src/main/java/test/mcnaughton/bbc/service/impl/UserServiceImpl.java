package test.mcnaughton.bbc.service.impl;

import test.mcnaughton.bbc.domain.UserDao;
import test.mcnaughton.bbc.models.User;
import test.mcnaughton.bbc.service.UserService;
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
