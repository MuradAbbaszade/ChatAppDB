/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.daoImpl;

import com.company.dao.FriendDAOInter;
import com.company.entity.Friend;
import com.company.entity.FriendRequest;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roma-cervice
 */
@Repository
public class FriendDAOImpl implements FriendDAOInter {

    @Autowired
    UserDAOImpl userDAO;
    
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public boolean sendFriendRequest(int fromUserId, int toUserId) {
        if (fromUserId == toUserId) {
            return false;
        }
        if (userDAO.getById(fromUserId) == null) {
            return false;
        }
        if (userDAO.getById(toUserId) == null) {
            return false;
        }
        if (isFriend(fromUserId, toUserId)) {
            return false;
        }
        if (isFriend(toUserId, fromUserId)) {
            return false;
        }
        if (getRequestId(fromUserId, toUserId) != null) {
            return false;
        }

        if (getRequestId(toUserId, fromUserId) != null) {
            int requestId = getRequestId(toUserId, fromUserId);
            return acceptFriendRequest(requestId);
        }
        FriendRequest friendRequest =  new FriendRequest(0,userDAO.getById(fromUserId),userDAO.getById(toUserId));
        em.merge(friendRequest);
        return true;
    }
    @Override
    public boolean acceptFriendRequest(Integer requestId) {
        if(requestId == null) return false;
        FriendRequest friendRequest = em.find(FriendRequest.class, requestId);
        if (friendRequest == null) {
            return false;
        }
        int fromUserId = friendRequest.getFromUser().getId();
        int toUserId = friendRequest.getToUser().getId();
        if (getRequestId(fromUserId, toUserId) == null) {
            return false;
        }
        Friend friend  = new Friend(0,userDAO.getById(fromUserId),userDAO.getById(toUserId));
        em.merge(friend);
        return declineFriendRequest(requestId);
    }

    public Integer getRequestId(int fromUserId, int toUserId) {
        Query q = em.createNativeQuery("select * from friend_request where from_user=:from_user AND to_user=:to_user", FriendRequest.class);
        q.setParameter("from_user", fromUserId);
        q.setParameter("to_user", toUserId);
        List<FriendRequest> requestList = q.getResultList();
        if (requestList.size() == 0) {
            return null;
        }
        return requestList.get(0).getId();
    }
    @Override
    public boolean declineFriendRequest(Integer requestId) {
        if(requestId==null) return false;
        FriendRequest friendRequest = em.find(FriendRequest.class, requestId);
        if (friendRequest == null) {
            return false;
        }
        em.remove(em.contains(friendRequest) ? friendRequest : em.merge(friendRequest));
        return true;
    }

    public boolean isFriend(int fromUserId, int toUserId) {
        Query q = em.createNativeQuery("select * from friend where friend_id=:friend_id AND user_id=:user_id", Friend.class);
        q.setParameter("friend_id", fromUserId);
        q.setParameter("user_id", toUserId);
        List<Friend> friendList = q.getResultList();
        if (friendList.size() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<FriendRequest> getAllRequests() {
        Query q = em.createNativeQuery("Select * from friend_request",FriendRequest.class);
        List<FriendRequest> requests = q.getResultList();
        return requests;
    }
}
