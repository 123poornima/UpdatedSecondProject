package com.niit.backend.dao;
import java.util.List;

import com.niit.backend.model.Friend;
import com.niit.backend.model.Job;
public interface FriendDao
{
	public void addFriend(Friend friend);
	List<Friend> getAllFriends(String username);
	void sendFriendRequest(String from,String to);
	List<Friend> getPendingRequest(String username);
	void updatePendingRequest(char friendStatus,String fromId,String toId);
}
