package library_management_system.main;

import java.util.Scanner;

import library_management_system.entiry.User;
import library_management_system.service.UserService;
import library_management_system.service.UserServiceImpl;

public class UserTest {

	static UserService service = new UserServiceImpl();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		do {

			System.out.println("1.ADD USER \n2.SEARCH \n3.UPDATE \n4.REMOVE \n5.SHOWALL \n6.Exit");
			System.out.println("Enter your choice");
			int option = sc.nextInt();
			sc.nextLine();

			switch (option) {

			case 1: {
				User user = takeInputForUserObject();
				service.createUser(user);
				break;

			}
			case 2: {
				System.out.println("Enter USERID");
				String userId = sc.nextLine();
				User user = service.getUserById(userId);
				System.out.println(user);
				break;
			}
			case 3: {
				System.out.println("Enter USERID");
				String userID = sc.nextLine();
				User userToBeUpdated = service.getUserById(userID);
				if (userToBeUpdated == null) {
					System.out.println("User is not present with userId : " + userID);
				} else {
					service.deleteUser(userID);
					User updatedUser = userInput(userToBeUpdated);
					service.createUser(updatedUser);
				}

				break;
			}
			case 4: {
				System.out.println("Enter UserId");
				String userId = sc.nextLine();
				service.deleteUser(userId);
				break;
			}
			case 5: {
				System.out.println("==All Users==");
				for (User user : service.getAllUsers()) {
					System.out.println(user);
				}
				break;
			}
			case 6: {
				System.out.println("Exit.....");
				System.exit(0);
			}

			default: {
				System.out.println("Enter valid input");
			}

			}
		} while (true);

	}

	public static User userInput(User user) {

		System.out.println("Enter Your Choice \n1.Edit Name \n2.Edit Password \n3.Edit Phone \n4.Edit Email");
		int option = sc.nextInt();
		switch (option) {
		case 1: {
			String name = sc.nextLine();
			user.setName(name);
			break;
		}
		case 2: {
			String password = sc.nextLine();
			user.setPassword(password);
			break;
		}
		case 3: {
			Long phone = sc.nextLong();
			user.setPhoneNumber(phone);
			break;
		}
		case 4: {
			String email = sc.nextLine();
			user.setEmail(email);
			break;
		}
		default: {
			System.out.println("Enter valid option");
		}
		}

		return user;

	}

	public static User takeInputForUserObject() {
		System.out.println("Enter User Name");
		String name = sc.nextLine();
		System.out.println("Enter UserID");
		String userId = sc.nextLine();
		System.out.println("Enter Password");
		String password = sc.nextLine();
		User user = new User(name, userId, password);
		return user;
	}

}
