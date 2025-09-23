package library_management_system.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
		super("user is not presnt");
	}
}
