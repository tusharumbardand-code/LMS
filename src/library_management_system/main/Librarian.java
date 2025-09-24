package library_management_system.main;

import library_management_system.entiry.Book;

public class Librarian {

	static private String id = "lab@123";
	static private String password = "321";

	public void librarianLogin() {
		System.out.println("Enter id");
		Driver.sc.nextLine();
		String id = Driver.sc.nextLine();
		System.out.println("enter password");
		String password = Driver.sc.nextLine();
		System.out.println(id);
		System.out.println(password);
		if (Librarian.id.equals(id) && Librarian.password.equals(password)) {
			librarianView();
		} else {
			System.out.println("Wrong id or password");
			return;
		}
	}

	private void librarianView() {

		do {
			System.out.println("1.Add Book \n2.search book \n3.show all books \n4.show all users \n5.remove book \n6.Exit...");
			int option = Driver.sc.nextInt();
			switch (option) {
			case 1: {
				LibraryManagementSystemApp.bookInput();
				break;
			}
			case 2: {
				System.out.println("Enter the name");
				String name = Driver.sc.nextLine();
				Book book = Driver.bookService.getAllBooks().stream().filter(e -> e.getName().equals(name)).findFirst()
						.orElse(null);
				if (book == null) {
					System.out.println("book with the given name is not presnet ");
					break;
				} else {
					System.out.println(book);

				}
				break;
			}
			case 3: {

				Driver.bookService.getAllBooks().forEach(e -> System.out.println(e));
				break;
			}
			case 4: {
				Driver.service.getAllUsers().forEach(e -> System.out.println(e));
				break;
			}
			case 5: {
				System.out.println("Enter the book name");
				Driver.sc.nextLine();
				String name = Driver.sc.nextLine();
				Driver.bookService.removeBookByName(name);
				break;
			}
			case 6 :{
				System.out.println("Exit...");
				return ;
			}
			default: {
				System.out.println("Enter the valid input");
			}
			}
		} while (true);

	}

}
