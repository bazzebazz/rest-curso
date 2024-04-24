package com.donjavidev.restcurso.controllers;

import com.donjavidev.restcurso.models.User;
import com.donjavidev.restcurso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    //*Todos los usuarios
    @RequestMapping(value = "", method = RequestMethod.GET)
    List<User> getAll() {
        return userService.getAll();
    }

    //*Usuario por Id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    //*Registro de usuarios
    @RequestMapping(value = "", method = RequestMethod.POST)
    User register(@RequestBody User user) {
        return userService.register(user);
    }

    //*Modificar - Actualizar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.update(id, user);
    }

    //*Eliminar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        userService.delete(id);
    }


}
