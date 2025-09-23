package library_management_system.service;

import java.util.List;

import library_management_system.entiry.User;

public interface UserService {

	void createUser(User user);
	boolean deleteUser(String userId);
	boolean updateUser(User user);
	List<User> getAllUsers();
	User getUserById(String UserId);

}
