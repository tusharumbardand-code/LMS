package library_management_system.service;

import java.util.List;

import library_management_system.entiry.Book;
import library_management_system.exception.BookNotFound;
import library_managment_system.dao.BookDAO;
import library_managment_system.dao.BookDAOImpl;

public class BookServiceImpl implements BookService {

	BookDAO bookDAO = new BookDAOImpl();

	@Override
	public void addBook(Book book) {

		bookDAO.addBook(book);

	}

	@Override
	public boolean removeBookByName(String name) {

		Book bookToBeRemoved = bookDAO.searchByName(name);

		return bookDAO.remove(bookToBeRemoved);
	}

	@Override
	public Book searchByName(String name) {

		return bookDAO.searchByName(name);
	}

	@Override
	public boolean update(Book book) {
		Book bookToBeUpdated = bookDAO.searchByName(book.getName());
		if (bookToBeUpdated == null) {
			throw new BookNotFound();

		}
		bookDAO.remove(bookToBeUpdated);
		bookDAO.addBook(book);
		return true;

	}

	public void showAllBooks() {
		bookDAO.getAllBooks().stream().forEach(book -> System.out.println(book));
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDAO.getAllBooks().stream().toList();
	}

}
