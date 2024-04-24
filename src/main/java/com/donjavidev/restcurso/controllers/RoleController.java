package com.donjavidev.restcurso.controllers;

import com.donjavidev.restcurso.models.Role;
import com.donjavidev.restcurso.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Role> getAll() {
        return roleService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Role get(@PathVariable long id) {
        return roleService.getRole(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Role register(@RequestBody Role role) {
        return roleService.register(role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Role update(@PathVariable Long id, @RequestBody Role role) {
        return roleService.update(id, role);
    }

    // Registrar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        roleService.delete(id);
    }
}
