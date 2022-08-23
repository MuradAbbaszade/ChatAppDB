/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao;

/**
 *
 * @author roma-cervice
 */
public interface FriendDAOInter {
    public boolean sendFriendRequest(int fromUserId, int toUserId);
    public boolean acceptFriendRequest(Integer requestId);
    public Integer getRequestId(int fromUserId, int toUserId);
    public boolean declineFriendRequest(Integer requestId);
    public boolean isFriend(int fromUserId, int toUserId);
}
