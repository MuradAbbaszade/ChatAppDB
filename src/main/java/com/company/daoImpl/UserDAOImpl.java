package com.company.daoImpl;

import com.company.config.PasswordEncoder;
import com.company.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.company.dao.UserDAOInter;
import com.company.entity.Friend;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

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

    @Override
    @Transactional
    public boolean addFriend(int userId, int friendId) {
        Query q = em.createNativeQuery("Select * from user where id=:id", User.class);
        q.setParameter("id", userId);
        List<User> list = q.getResultList();
        if (list.size() == 0) {
            return false;
        }
        User user = list.get(0);
        Query q1 = em.createNativeQuery("Select * from user where id=:id", User.class);
        q1.setParameter("id", friendId);
        List<User> list1 = q1.getResultList();
        if (list1.size() == 0) {
            return false;
        }
        User user1 = list1.get(0);
        Friend friend = new Friend(0, friendId);
        friend.setUser(user);
        Query q2 = em.createNativeQuery("INSERT INTO  friend(id,user_id,friend_id) VALUES(?,?,?)", Friend.class);
        q2.setParameter(1, 0);
        q2.setParameter(2, userId);
        q2.setParameter(3, friendId);
        q2.executeUpdate();
        return true;
    }

    @Override
    @Transactional
    public boolean deleteFriend(int userId, int friendId) {
        Query q = em.createNativeQuery("Select * from user where id=:id", User.class);
        q.setParameter("id", userId);
        List<User> list = q.getResultList();
        if (list.size() == 0) {
            return false;
        }
        User user = list.get(0);
        Query q1 = em.createNativeQuery("Select * from user where id=:id", User.class);
        q1.setParameter("id", friendId);
        List<User> list1 = q1.getResultList();
        if (list1.size() == 0) {
            return false;
        }
        User user1 = list1.get(0);
        Friend friend = new Friend(0, friendId);
        friend.setUser(user);
        Query q2 = em.createNativeQuery("Delete from friend where user_id=:userId", Friend.class);
        q2.setParameter("userId", userId);
        q2.executeUpdate();
        return true;
    }

}
