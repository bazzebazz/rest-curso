package com.donjavidev.restcurso.dao;

import com.donjavidev.restcurso.models.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAll();
    Role getRole(long id);
    Role register(Role role);
    Role update(Long id, Role role);
    void delete(long id);
}
