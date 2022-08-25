/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.company.daoImpl.FriendDAOImpl;
import com.company.entity.Friend;
import com.company.entity.FriendRequest;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author roma-cervice
 */
@Transactional
@Service
public class FriendDAOService {
    
    @Autowired 
    FriendDAOImpl friendDAO;
    
    public boolean sendFriendRequest(int fromUserId, int toUserId){
        return friendDAO.sendFriendRequest(fromUserId, toUserId);
    }
    public boolean acceptFriendRequest(int requestId){
        return friendDAO.acceptFriendRequest(requestId);
    }

    public Integer getRequestId(int fromUserId, int toUserId){
        return friendDAO.getRequestId(fromUserId, toUserId);
    }

    public boolean declineFriendRequest(int requestId){
        return friendDAO.declineFriendRequest(requestId);
    }

    public boolean isFriend(int fromUserId, int toUserId){
        return friendDAO.isFriend(fromUserId, toUserId);
    }
    
    public List<FriendRequest> getAllRequest(){
        return friendDAO.getAllRequests();
    }
    
    public List<Friend> getAllFriends() {
        return friendDAO.getAllFriends();
    }
    
    public boolean deleteFriend(Integer id) {
        return friendDAO.deleteFriend(id);
    }
    
    public Integer getFriendsId(int userId, int friendId) {
        return friendDAO.getFriendsId(userId, friendId);
    }
}
