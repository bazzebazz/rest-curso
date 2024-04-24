package com.donjavidev.restcurso.services;

import com.donjavidev.restcurso.dao.PermisoDao;
import com.donjavidev.restcurso.models.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PermisoService {
    @Autowired
    PermisoDao permisoDao;

    public List<Permiso> getAll() {
        return permisoDao.getAll();
    }

    public Permiso getPermiso(long id) {
        return permisoDao.getPermiso(id);
    }

    public Permiso register(Permiso permiso) {
        return permisoDao.register(permiso);
    }

    public Permiso update(Long id, Permiso updatedPermiso) {
        return permisoDao.update(id, updatedPermiso);
    }

    public void delete(@PathVariable long id) {
        permisoDao.delete(id);
    }
}
