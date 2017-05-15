package test.mcnaughton.bbc.domain;

import org.junit.Test;
import test.mcnaughton.bbc.domain.impl.InMemUserDao;
import test.mcnaughton.bbc.models.User;

import static org.junit.Assert.*;

public class TestUserDao {

    private UserDao userDao = new InMemUserDao();

    @Test
    public void testAddUser(){
        String username = "testUserName";

        User newUser = userDao.addUser(username);

        assertEquals(username, newUser.getName());
        assertNotNull(newUser.getId());
        assertEquals(0, newUser.getNumTimesVoted());
    }

    @Test
    public void testGetUser(){
        String userName = "testUserName";

        User newUser = userDao.addUser(userName);

        User retrivedUser = userDao.getUser(newUser.getId());

        assertEquals(retrivedUser, newUser);
    }
}
