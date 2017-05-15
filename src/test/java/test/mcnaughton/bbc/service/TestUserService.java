package test.mcnaughton.bbc.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import test.mcnaughton.bbc.domain.UserDao;
import test.mcnaughton.bbc.models.User;
import test.mcnaughton.bbc.service.impl.UserServiceImpl;

import javax.annotation.Resource;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestUserService {

    @Mock
    private UserDao userDao;

    @InjectMocks
    @Resource
    private UserServiceImpl userService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUser(){
        String userName = "testUser";
        when(userDao.addUser(userName)).thenReturn(
                new User(UUID.randomUUID(), userName));
        User newUser = userService.addUser(userName);
        verify(userDao, times(1)).addUser(userName);
        assertEquals(newUser.getName(), userName);
        assertNotNull(newUser.getId());
        assertEquals(newUser.getNumTimesVoted(), 0);
    }

    @Test
    public void testGetUser(){
        User user = new User(UUID.randomUUID(), "testName");
        when(userDao.getUser(user.getId())).thenReturn(user);

        User retrivedUser = userService.getUser(user.getId());

        verify(userDao, times(1)).getUser(user.getId());
        assertEquals(user, retrivedUser);
    }

}
