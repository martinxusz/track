package com.track.dao;

import java.util.List;

import com.track.entity.Track;
import com.track.entity.Users;

public interface IUsersDAO {
	public List<Users> getUsersByType(int type, int size,int pageNo);
	public int getUsersTotalByType(int type);
	public void updateUsers(Users user);
	public Users getUsersByName(String name);
	public Users getUsersById(int id);
	public void addUsers(Users user );
	public void deleteUsers(Users user );
	
	public int getAllUsersTotal();
	public List<Users> getAllUsers(int size,int pageNo);
	
	
}
