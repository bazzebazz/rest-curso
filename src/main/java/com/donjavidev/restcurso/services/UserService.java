package com.donjavidev.restcurso.services;

import com.donjavidev.restcurso.dao.UserDao;
import com.donjavidev.restcurso.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getUser(long id) {
        return userDao.getUser(id);
    }

    public User register(User user) {
        return userDao.register(user);
    }

    public User update(Long id, User updatedUser) {
        return userDao.update(id, updatedUser);
    }

    public void delete(@PathVariable long id) {
        userDao.delete(id);
    }

}
