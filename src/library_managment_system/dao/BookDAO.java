package library_managment_system.dao;

import java.util.List;

import library_management_system.entiry.Book;

public interface BookDAO {
	
	public void addBook(Book book) ;
	public boolean remove(Book book) ;
	public Book searchByName(String name);
	public List<Book> getAllBooks();

}
