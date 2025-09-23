package library_management_system.service;

import java.util.List;

import library_management_system.entiry.User;
import library_managment_system.dao.UserDAO;
import library_managment_system.dao.UserDAOImpl;

public class UserServiceImpl implements UserService {

	UserDAO userDao = new UserDAOImpl();

	@Override
	public void createUser(User user) {
		userDao.addUser(user);

	}

	@Override
	public boolean deleteUser(String userId) {

		return userDao.deleteUser(userId);
	}

	@Override
	public boolean updateUser(User user) {

		return userDao.editUser(user);
	}

	@Override
	public List<User> getAllUsers() {

		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(String UserId) {

		return userDao.getUserById(UserId);
	}

}
