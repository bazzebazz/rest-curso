package com.donjavidev.restcurso.dao.imp;

import com.donjavidev.restcurso.dao.UserDao;
import com.donjavidev.restcurso.models.User;
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
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<User> getAll(){
//        String hql = "FROM User as u ";
//        return (List<User>) entityManager.createQuery(hql).getResultList();
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public User getUser(long id){
        return entityManager.find(User.class, id);
    }

    @Override
    public User register(User user){
        entityManager.merge(user);
        return user;
    }

    @Transactional
    @Override
    public User update(Long id, User updatedUser){
        if(updatedUser == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este usuario no existe o es nulo");
        }

        User existingUser = entityManager.find(User.class, id);
        if (existingUser != null) {
            existingUser.setNombre(updatedUser.getNombre());
            existingUser.setApellido(updatedUser.getApellido());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setTelefono(updatedUser.getTelefono());
            existingUser.setFechaNacimiento(updatedUser.getFechaNacimiento());

            return existingUser;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        }
    }

    @Transactional
    @Override
    public void delete(long id){
        User user = getUser(id);
        entityManager.remove(user);
    }
}
