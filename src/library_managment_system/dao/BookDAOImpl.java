package library_managment_system.dao;

import java.util.List;

import database.DataBase;
import library_management_system.entiry.Book;
import library_management_system.exception.BookNotFound;

public class BookDAOImpl implements BookDAO {

	public void addBook(Book book) {
		DataBase.books.add(book);
	}

	public boolean remove(Book book) {
		return DataBase.books.remove(book);
	}

	public Book searchByName(String name) {
		return DataBase.books.stream().filter(book -> book.getName().equalsIgnoreCase(name)).
				findFirst().orElseThrow(()-> new BookNotFound());

	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return DataBase.books;
	}

}
