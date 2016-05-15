package communication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import tests.Error;

public class DatabaseConnection {

	private static DatabaseConnection DBInstance;
	private static Connection connection;

	private DatabaseConnection() {
		// private constructor //
	}

	public static DatabaseConnection getInstance() {
		if (DBInstance == null) {
			DBInstance = new DatabaseConnection();
		}
		return DBInstance;
	}

	public Connection getConnection() {

		if (connection == null) {

			try {
				String url = "jdbc:mysql://localhost:3306/arduino_app?useSSL=false";
				String username = "musician";
				String password = "musician";
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException se) {
				int count = 1;
				while (se != null) {
					new Error();
					System.out.println("SQLException " + count);
					System.out.println("Code: " + se.getErrorCode());
					System.out.println("SqlState: " + se.getSQLState());
					System.out.println("Error Message: " + se.getMessage());
					se = se.getNextException();
					count++;
				}
			}
		}

		return connection;
	}

}
