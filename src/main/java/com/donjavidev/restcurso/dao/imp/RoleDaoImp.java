package com.donjavidev.restcurso.dao.imp;

import com.donjavidev.restcurso.dao.RoleDao;
import com.donjavidev.restcurso.models.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Transactional
@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Role> getAll(){
//        String hql = "FROM Role as u ";
//        return (List<Role>) entityManager.createQuery(hql).getResultList();
        TypedQuery<Role> query = entityManager.createQuery("SELECT u FROM Role u", Role.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Role getRole(long id){
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role register(Role role){
        entityManager.merge(role);
        return role;
    }

    @Transactional
    @Override
    public Role update(Long id, Role updatedRole){
        if(updatedRole == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este usuario no existe o es nulo");
        }

        Role existingRole = entityManager.find(Role.class, id);
        if (existingRole != null) {
            existingRole.setNombre(updatedRole.getNombre());

            return existingRole;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        }
    }

    @Transactional
    @Override
    public void delete(long id){
        Role role = getRole(id);
        entityManager.remove(role);
    }
}
