
package com.company.dao;

import com.company.entity.Friend;
import com.company.entity.FriendRequest;
import java.util.List;

public interface FriendDAOInter {
    public boolean sendFriendRequest(int fromUserId, int toUserId);
    public boolean acceptFriendRequest(Integer requestId);
    public Integer getRequestId(int fromUserId, int toUserId);
    public boolean declineFriendRequest(Integer requestId);
    public boolean isFriend(int fromUserId, int toUserId);
    public List<FriendRequest> getAllRequests();
    public List<Friend> getAllFriends();
    public boolean deleteFriend(Integer id);
    public Integer getFriendsId(int userId,int friendId);
}
