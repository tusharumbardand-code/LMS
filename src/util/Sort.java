package util;

import database.DataBase;

public class Sort {

	public static void sortByRating() {
		DataBase.books.stream().sorted((b1, b2) -> b2.getRating().compareTo(b1.getRating()))
				.forEach(book -> System.out.println(book));
	}

	public static void sortByName() {
		DataBase.books.stream().sorted((b1, b2) -> b1.getName().compareTo(b2.getName()))
				.forEach(book -> System.out.println(book));
	}

	public static void sortByCategory() {
		DataBase.books.stream().sorted((b1, b2) -> b1.getCategory().compareTo(b2.getCategory()))
				.forEach(book -> System.out.println(book));
	}

}
