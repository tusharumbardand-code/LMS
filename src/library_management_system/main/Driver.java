package library_management_system.main;

import java.util.Scanner;

import library_management_system.entiry.Book;
import library_management_system.entiry.User;
import library_management_system.service.BookService;
import library_management_system.service.BookServiceImpl;
import library_management_system.service.UserService;
import library_management_system.service.UserServiceImpl;

public class Driver {

	static Scanner sc = new Scanner(System.in);
	static UserService service = new UserServiceImpl();
	static BookService bookService = new BookServiceImpl();

	public static void main(String[] args) {
		do {
			System.out.println("1.User Register \n2.User Login \n3.librarian Login");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				User user = UserTest.takeInputForUserObject();
				service.createUser(user);
				System.out.println("User with User ID : " + user.getUserId());
				System.out.println(service.getAllUsers());
				break;
			}
			case 2: {

				System.out.println("Enter UserID");
				sc.nextLine();
				String userId = sc.nextLine();
				System.out.println("Enter password");
				String password = sc.nextLine();
				System.out.println(userId);
				System.out.println(password);

				boolean flage = userLogIn(userId, password);
				if (flage) {
					userView(service.getUserById(userId));
				} else {
					System.out.println("wrong passwod");
				}
				break;
			}
			case 3: {
				System.out.println("librarian Login wait ...");
			}

			}
			sc.nextLine();
		} while (true);
	}

	public static boolean userLogIn(String userId, String password) {
		User user = service.getUserById(userId);
		if (user == null) {
			System.out.println("User with UserID : " + userId + "is not presnet");
			return false;
		}
		if (user.getPassword().equals(password)) {

			return true;
		}
		return false;
	}

	private static void userView(User user) {

		do {
			System.out.println("1.Show All Books \n2.Get Book By Name \n3.Return Book \n4.Edit \n5.Exit");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				bookService.getAllBooks().forEach(e -> System.out.println(e));
				break;
			}
			case 2: {
				sc.nextLine();
				System.out.println("Enter name");
				String name = sc.nextLine();
				Book book = bookService.getAllBooks().stream().filter(e -> e.getName().equals(name)).findFirst()
						.orElse(null);
				if (book == null) {
					System.out.println("book with the given name is not presnet ");
					break;
				} else {
					System.out.println(book);
					bookService.removeBookByName(book.getName());
					book.setCopy(book.getCopy() - 1);
					bookService.addBook(book);
					user.getBooks().add(book);

				}
				break;
			}
			case 3: {
				System.out.println("Enter name ");
				String name = sc.nextLine();
				Book bookToReturn = user.getBooks().stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst()
						.orElse(null);
				if(bookToReturn==null) {
					System.out.println("You dont have that book");
					break;
				}
				else {
					user.getBooks().remove(bookToReturn);
				    Book update	=bookService.searchByName(bookToReturn.getName());
				    bookService.removeBookByName(name);
				    update.setCopy(update.getCopy()+1);
				    bookService.addBook(update);
				    System.out.println("Book returned ");
				}
				break;
			}
			case 4: {
				sc.nextLine();
				System.out.println("Enter user ID");
				String userId = sc.nextLine();
				User userToFind = service.getAllUsers().stream().filter(e -> e.getUserId().equals(userId)).findFirst()
						.orElse(null);
				if (userToFind == null) {
					System.out.println("user is not present");
					break;
				} else {
					service.deleteUser(userId);
					UserTest.userInput(userToFind);
					service.createUser(userToFind);
					System.out.println("user data is updated ");
					break;
				}
			}
			case 5: {
				return;
			}
			}
		} while (true);
	}

}
