package library_management_system.main;

import java.util.Scanner;

import library_management_system.entiry.Book;
import library_management_system.service.BookService;
import library_management_system.service.BookServiceImpl;

public class LibraryManagementSystemApp {

	static BookService bookService = new BookServiceImpl();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		do {

			System.out.println("1.ADD BOOK \n2.SEARCH \n3.UPDATE \n4.REMOVE \n5.SHOWALL \n6.Exit");
			System.out.println("Enter your choice");
			int option = sc.nextInt();
			sc.nextLine();

			switch (option) {

			case 1: {
				bookInput();
				break;

			}
			case 2: {
				System.out.println("Enter name");
				String name = sc.nextLine();
				Book book = bookService.searchByName(name);
				System.out.println(book);
				break;
			}
			case 3: {
				System.out.println("Enter name");
				String name = sc.nextLine();
				Book book = bookService.searchByName(name);
				if (book == null) {
					System.out.println("Book is not present");
				} else {
					bookService.removeBookByName(name);
					inputForUpdate(book);
					bookService.addBook(book);
				}

				break;
			}
			case 4: {
				System.out.println("Enter name");
				String name = sc.nextLine();
				bookService.removeBookByName(name);
				break;
			}
			case 5: {
				System.out.println("==All Books==");
				bookService.showAllBooks();
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

	public static void bookInput() {
		System.out.println("Enter Book Name");
		String name = sc.nextLine();
		System.out.println("Enter Author ");
		String author = sc.nextLine();
		System.out.println("Enter Category");
		String category = sc.nextLine();
		System.out.println("Enter rating");
		double rating = sc.nextDouble();
		System.out.println("Enter number of Copies");
		int copies = sc.nextInt();
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setCategory(category);
		book.setRating(rating);
		book.setCopy(copies);
		bookService.addBook(book);
	}

	public static void inputForUpdate(Book book) {
		System.out.println("1.Update name \n2.Update Author \n3.Update Category \n4.Update Rating \n5.Update Copies");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			String name = sc.nextLine();
			book.setName(name);
			break;
		}
		case 2: {
			String author = sc.nextLine();
			book.setAuthor(author);
			break;
		}
		case 3: {
			String category = sc.nextLine();
			book.setCategory(category);
			break;
		}
		case 4: {
			double rating = sc.nextDouble();
			book.setRating(rating);
			break;
		}
		case 5: {
			int copy = sc.nextInt();
			book.setCopy(copy);
			break;
		}
		}
	}

}
