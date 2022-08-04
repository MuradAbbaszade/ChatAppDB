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
    public boolean insert(User u) {
        return userDAO.insert(u);
    }
    public int delete(User u) {
        return userDAO.delete(u);
    }
    public boolean update(User u) {
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
    public boolean findByEmail(String email){
        return userDAO.findByEmail(email);
    }
    
}
