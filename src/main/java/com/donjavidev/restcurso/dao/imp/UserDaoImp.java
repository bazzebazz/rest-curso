package com.donjavidev.restcurso.dao.imp;

import com.donjavidev.restcurso.dao.UserDao;
import com.donjavidev.restcurso.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<User> getAll(){
        //String hql = "FROM User as u ";
        //return (List<User>) entityManager.createQuery(hql).getResultList();
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
    public User update(User user){
        entityManager.merge(user);
        return user;
    }

    @Transactional
    @Override
    public void delete(long id){
        User user = getUser(id);
        entityManager.remove(user);
    }
}
