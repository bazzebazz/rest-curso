package com.donjavidev.restcurso.controllers;

import com.donjavidev.restcurso.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    //*Todos los usuarios
    @RequestMapping(value = "", method = RequestMethod.GET)
    List<User> getAll() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setNombre("Javier");
        user.setApellido("Urrutia");
        list.add(user);
        return list;
    }

    //*Usuario por Id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable long id) {
        User user = new User();
        user.setNombre("Javier");
        user.setApellido("Urrutia");
        return user;
    }

    //*Registro de usuarios
    @RequestMapping(value = "", method = RequestMethod.POST)
    User register(@RequestBody User user) {
        // TODO: registrar en bd
        return user;
    }

    //*Modificar - Actualizar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User update(@RequestBody User user) {
        // TODO: Actualizar en bd
        return user;
    }

    //*Eliminar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        //TODO: Eliminarlo en bd

    }


}
