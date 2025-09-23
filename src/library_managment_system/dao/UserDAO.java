package library_managment_system.dao;

import java.util.List;

import library_management_system.entiry.User;

public interface UserDAO {
	
	
	User getUserById(String userId);
	boolean addUser(User user);
	boolean deleteUser(String userId);
	boolean editUser(User user);
	List<User> getAllUsers();
	

}
