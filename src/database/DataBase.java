package database;

import java.util.ArrayList;

import library_management_system.entiry.Book;
import library_management_system.entiry.User;

public class DataBase {

	public static ArrayList<Book> books = new ArrayList<>();
	public static ArrayList<User> users = new ArrayList<>();
	static {
		Book b1 = new Book();
		b1.setName("JAVA");
		b1.setAuthor("RAJU");
		b1.setCopy(5);
		Book b2 = new Book();
		b2.setName("C++");
		b2.setAuthor("BABU");
		b2.setCopy(5);
		books.add(b1);
		books.add(b2);
	}

}
