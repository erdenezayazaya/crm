package edu.mum.mpp.zayagerman.services;

import java.util.List;

import edu.mum.mpp.zayagerman.businessLogic.UserLogic;
import edu.mum.mpp.zayagerman.user.User;

public class UserService {
	public static boolean resetPassword(int id, String password)
	{
		return UserLogic.resetPassword(id, password);
	}
	
	public static boolean createUser(User user)
	{
		return UserLogic.createUser(user);
	}
	
	public static User getUser(int id)
	{
		return UserLogic.getUser(id);
	}
	
	public static List<User> getUserList()
	{
		return UserLogic.getUserList();
	}
}
