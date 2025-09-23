package library_management_system.exception;

public class BookNotFound  extends RuntimeException{
    public BookNotFound() {
		super("Book is not present");
	}
}
