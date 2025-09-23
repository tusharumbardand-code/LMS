package library_managment_system.dao;

import java.util.List;

import database.DataBase;
import library_management_system.entiry.User;

public class UserDAOImpl implements UserDAO {
	
	

	@Override
	public User getUserById(String userId) {
		User userToReturn = DataBase.users.stream().filter(user -> user.getUserId().equalsIgnoreCase(userId))
				.findFirst().get();
		return userToReturn;

	}

	@Override
	public boolean addUser(User user) {
		return DataBase.users.add(user);
	}

	@Override
	public boolean deleteUser(String userId) {
		User userToBeDeleted = DataBase.users.stream().filter(user -> user.getUserId().equalsIgnoreCase(userId))
				.findFirst().get();
		if (userToBeDeleted == null) {
			return false;
		}
		DataBase.users.remove(userToBeDeleted);
		return true;
	}

	@Override
	public boolean editUser(User user) {
		User UserToBeUpdated = getUserById(user.getUserId());
		if (UserToBeUpdated == null) {
			return false;
		}
		DataBase.users.remove(UserToBeUpdated);
		addUser(user);
		return true;
	}

	public List<User> getAllUsers() {
		return DataBase.users;
	}

}
