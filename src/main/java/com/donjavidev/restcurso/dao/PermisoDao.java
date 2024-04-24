package com.donjavidev.restcurso.dao;

import com.donjavidev.restcurso.models.Permiso;

import java.util.List;

public interface PermisoDao {
    List<Permiso> getAll();
    Permiso getPermiso(long id);
    Permiso register(Permiso permiso);
    Permiso update(Long id, Permiso permiso);
    void delete(long id);
}
