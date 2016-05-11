package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = null;
		Statement stm = null;
		ResultSet result = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "musician", "musician");
			System.out.println("Success!");

			stm = conn.createStatement();
			String sql = "Select * from employees";
			result = stm.executeQuery(sql);

			while (result.next()) {
				System.out.println(result.getString("first_name") + " || " + result.getString("last_name"));
			}

		} catch (SQLException se) {

			int count = 1;
			while (se != null) {
				System.out.println("SQLException " + count);
				System.out.println("Code: " + se.getErrorCode());
				System.out.println("SqlState: " + se.getSQLState());
				System.out.println("Error Message: " + se.getMessage());
				se = se.getNextException();
				count++;
			}

		}
	}
}
