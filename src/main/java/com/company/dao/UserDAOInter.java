
package com.company.dao;

import com.company.entity.User;
import java.util.List;

public interface UserDAOInter{
    public List<User> getAll();
    public User insert(User u);
    public int delete(User u);
    public User update(User u);
    public User getById(int id);
    public List<User> findByName(String name);
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email,String password);
}
