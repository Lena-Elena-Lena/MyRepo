package my;

import my.database.DatabaseHelper;

public class MainClass {

	public static void main(String[] args) {
		try {
			System.out.println(DatabaseHelper.prepareInsertQuery(new Student()));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
