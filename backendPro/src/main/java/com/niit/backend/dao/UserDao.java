package com.niit.backend.dao;
import java.util.List;

import com.niit.backend.model.User;

public interface UserDao 
{
	 public void addUser(User user);
	public User authenticate(User user);
	public void updateUser(User user);
	public User registerUser(User user);
	public List<User> userList();
}
