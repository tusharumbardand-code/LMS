package library_management_system.entiry;

import java.util.ArrayList;
import java.util.Objects;

public class User {

	private String name;
	private String userId;
	private long phoneNumber;
	private String password;
	private String email;
	private ArrayList<Book> Books = new ArrayList<>();

	public User(String name, String userId, long phoneNumber, String password, String email) {
		this.name = name;
		this.userId = userId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.email = email;
	}

	public User(String name, String userId, String password) {
		this.name = name;
		this.userId = userId;
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Book> getBooks() {
		return Books;
	}

	public void setBooks(ArrayList<Book> books) {
		Books = books;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Books, email, name, password, phoneNumber, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(Books, other.Books) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& phoneNumber == other.phoneNumber && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", userId=" + userId + ", phoneNumber=" + phoneNumber + ", password=" + password
				+ ", email=" + email + ", Books=" + Books + "]";
	}

	
	

}
