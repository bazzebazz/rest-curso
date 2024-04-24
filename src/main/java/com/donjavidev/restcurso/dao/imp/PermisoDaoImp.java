package com.donjavidev.restcurso.dao.imp;

import com.donjavidev.restcurso.dao.PermisoDao;
import com.donjavidev.restcurso.models.Permiso;
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
public class PermisoDaoImp implements PermisoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Permiso> getAll(){
//        String hql = "FROM Permiso as u ";
//        return (List<Permiso>) entityManager.createQuery(hql).getResultList();
        TypedQuery<Permiso> query = entityManager.createQuery("SELECT u FROM Permiso u", Permiso.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Permiso getPermiso(long id){
        return entityManager.find(Permiso.class, id);
    }

    @Override
    public Permiso register(Permiso permiso){
        entityManager.merge(permiso);
        return permiso;
    }

    @Transactional
    @Override
    public Permiso update(Long id, Permiso updatedPermiso){
        if(updatedPermiso == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este usuario no existe o es nulo");
        }

        Permiso existingPermiso = entityManager.find(Permiso.class, id);
        if (existingPermiso != null) {
            existingPermiso.setNombre(updatedPermiso.getNombre());

            return existingPermiso;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        }
    }

    @Transactional
    @Override
    public void delete(long id){
        Permiso permiso = getPermiso(id);
        entityManager.remove(permiso);
    }
}
