package edu.mum.mpp.zayagerman.service;

import java.util.List;

import edu.mum.mpp.zayagerman.entity.User;

public interface UserDAO {
	public void addUser(User user);
    public void deleteUser(int usertId);
    public void updateUser(User user);
    public List<User> getAllUsers();
    public User getUserById(int userId);
}
