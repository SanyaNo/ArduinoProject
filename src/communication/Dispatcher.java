package communication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dispatcher {
	
	private static Connection connection = DatabaseConnection.getInstance().getConnection();
	
	public Dispatcher (){
		
	}
	
	
	public ArrayList<String> getSheets(){
		ArrayList<String> sheets = new ArrayList<String>();
		
		String sql = "select sheet from sheet";
		try{
			
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet result = stm.executeQuery();
			while(result.next()){
				sheets.add(result.getString("sheet"));
			}
			
		}catch(SQLException se){
			new SQLError(se);
		}
		
		return sheets;
	}
	
}
