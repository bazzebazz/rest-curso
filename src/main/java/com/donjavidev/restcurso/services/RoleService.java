package com.donjavidev.restcurso.services;

import com.donjavidev.restcurso.dao.RoleDao;
import com.donjavidev.restcurso.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public List<Role> getAll() {
        return roleDao.getAll();
    }

    public Role getRole(long id) {
        return roleDao.getRole(id);
    }

    public Role register(Role role) {
        return roleDao.register(role);
    }

    public Role update(Long id, Role updatedRole) {
        return roleDao.update(id, updatedRole);
    }

    public void delete(@PathVariable long id) {
        roleDao.delete(id);
    }
}
