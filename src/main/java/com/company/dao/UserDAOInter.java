/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao;

import com.company.entity.User;
import java.util.List;

/**
 *
 * @author roma-cervice
 */
public interface UserDAOInter{
    public List<User> getAll();
    public boolean insert(User u);
    public int delete(User u);
    public boolean update(User u);
    public User getById(int id);
    public List<User> findByName(String name);
    public boolean findByEmail(String email);
    public User findByEmailAndPassword(String email,String password);
}
