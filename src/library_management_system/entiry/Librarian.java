package library_management_system.entiry;

import java.util.Objects;

public class Librarian {

	private String userId;
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Librarian [userId=" + userId + " ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Librarian other = (Librarian) obj;
		return Objects.equals(password, other.password) && Objects.equals(userId, other.userId);
	}
	

}
