/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.company.dao.UserDAOInter;
import com.company.entity.User;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author roma-cervice
 */
@Service
@Transactional
public class UserDAOService {

    @Autowired
    UserDAOInter userDAO;

    public List<User> getAll() {
        return userDAO.getAll();
    }

    public User insert(User u) {
        return userDAO.insert(u);
    }

    public int delete(User u) {
        return userDAO.delete(u);
    }

    public User update(User u) {
        return userDAO.update(u);
    }

    public User getById(int id) {
        return userDAO.getById(id);
    }

    public List<User> findByName(String name) {
        return userDAO.findByName(name);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userDAO.findByEmailAndPassword(email, password);
    }

    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    public boolean addFriend(int userId, int friendId) {
        return userDAO.addFriend(userId, friendId);
    }

    public boolean deleteFriend(int userId, int friendId) {
        return userDAO.deleteFriend(userId, friendId);
    }

}
