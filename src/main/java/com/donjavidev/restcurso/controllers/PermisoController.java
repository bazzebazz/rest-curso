package com.donjavidev.restcurso.controllers;

import com.donjavidev.restcurso.models.Permiso;
import com.donjavidev.restcurso.services.PermisoService;
import com.donjavidev.restcurso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permiso")
public class PermisoController {
    @Autowired
    PermisoService permisoService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Permiso> getAll() {
        return permisoService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Permiso get(@PathVariable long id) {
        return permisoService.getPermiso(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Permiso register(@RequestBody Permiso permiso) {
        return permisoService.register(permiso);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Permiso update(@PathVariable Long id, @RequestBody Permiso permiso) {
        return permisoService.update(id, permiso);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        permisoService.delete(id);
    }
}
