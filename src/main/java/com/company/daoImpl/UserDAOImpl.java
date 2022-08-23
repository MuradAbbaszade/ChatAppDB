package com.company.daoImpl;

import com.company.config.PasswordEncoder;
import com.company.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.company.dao.UserDAOInter;

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
    public User insert(User u) {
        em.merge(u);
        return u;
    }

    @Override
    public int delete(User u) {
        em.remove(em.contains(u) ? u : em.merge(u));
        return u.getId();
    }

    @Override
    public User update(User u) {
        em.merge(u);
        return u;
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
        User user = null;
        for (User u : list) {
            if (PasswordEncoder.verifyUserPassword(password, u.getPassword())) {
                user = u;
            }
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        Query q = em.createNativeQuery("Select * from user where email=:email", User.class);
        q.setParameter("email", email);
        List<User> list = q.getResultList();
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}
