package communication;

import java.sql.SQLException;

public class SQLError {
	public SQLError(SQLException se){
		
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