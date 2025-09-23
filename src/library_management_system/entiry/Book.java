package library_management_system.entiry;

import java.util.ArrayList;
import java.util.Objects;

public class Book {

	private String name;
	private String author;
	private String category;
	private Double rating;
	private ArrayList<Record> records = new ArrayList<Record>();
    private int copy ;
	public int getCopy() {
		return copy;
	}

	public void setCopy(int copy) {
		this.copy = copy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public ArrayList<Record> getRecords() {
		return records;
	}

	public void setRecords(ArrayList<Record> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", category=" + category + ", rating=" + rating
				+ ", records=" + records + ", copy=" + copy + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, category, copy, name, rating, records);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(category, other.category) && copy == other.copy
				&& Objects.equals(name, other.name) && Objects.equals(rating, other.rating)
				&& Objects.equals(records, other.records);
	}
	
	

}
