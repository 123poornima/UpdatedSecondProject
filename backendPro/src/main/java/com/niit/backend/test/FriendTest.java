package com.niit.backend.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.FriendDao;
import com.niit.backend.dao.JobDao;
import com.niit.backend.model.Friend;
import com.niit.backend.model.Job;

public class FriendTest 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
		FriendDao friendDao= (FriendDao) context.getBean("friendDao");

		Friend friend=(Friend) context.getBean("friend");
		
		//friend.setFromId("2");
		//friend.setToId("3");
		//friend.setStatus('a');
		
		
		
		
		friendDao.sendFriendRequest("poornima","vvv");

	}

}
