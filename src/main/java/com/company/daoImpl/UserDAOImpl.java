/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.daoImpl;

import com.company.config.PasswordEncoder;
import com.company.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.company.dao.UserDAOInter;
import org.springframework.stereotype.Component;

/**
 *
 * @author roma-cervice
 */
@Repository
public class UserDAOImpl implements UserDAOInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAll() {
        Query q = em.createNativeQuery("Select * from user", User.class);
        List<User> list = q.getResultList();
        return list;
    }

    @Override
    public boolean insert(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public int delete(User u) {
        em.remove(em.contains(u) ? u : em.merge(u));
        return u.getId();
    }

    @Override
    public boolean update(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public User getById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findByName(String name) {
        Query q = em.createNativeQuery("Select * from user where name=:name", User.class);
        q.setParameter("name", name);
        List list = q.getResultList();
        return list;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        Query q = em.createNativeQuery("Select * from user where email=:email", User.class);
        q.setParameter("email", email);
        List<User> list = q.getResultList();
        User user =null;
        for(User u : list){
            if(PasswordEncoder.verifyUserPassword(password, u.getPassword())){
                user =u;
            }
        }
        return user;
    }
    public boolean findByEmail(String email){
        Query q = em.createNativeQuery("Select * from user where email=:email", User.class);
        q.setParameter("email", email);
        List list = q.getResultList();
        if(list.isEmpty()){
            return false;
        }
        return true;
    }

}
