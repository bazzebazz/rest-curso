package com.donjavidev.restcurso.dao;

import com.donjavidev.restcurso.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getUser(long id);
    User register(User user);
    User update(Long id, User user);
    void delete(long id);
}
