package library_management_system.service;

import java.util.List;

import library_management_system.entiry.Book;

public interface BookService {
	
	void addBook(Book book);
	boolean removeBookByName(String name);
	Book searchByName(String name);
	boolean update(Book book);
	public void showAllBooks();
	public List<Book> getAllBooks();
}
