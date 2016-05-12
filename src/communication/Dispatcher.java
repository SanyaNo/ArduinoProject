package communication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Sheet;

public class Dispatcher {
	
	private static Connection connection = DatabaseConnection.getInstance().getConnection();
	
	public Dispatcher (){
		
	}
	
	
	public static ArrayList<Sheet> getSheets(){
		ArrayList<Sheet> sheets = new ArrayList<Sheet>();
		
		String sql = "select id, sheet from arduino_app.sheet";
		try{
			
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet result = stm.executeQuery();
			while(result.next()){
				Sheet currentSheet = new Sheet();
				currentSheet.setId(result.getInt("id"));
				currentSheet.setName(result.getString("sheet"));
				sheets.add(currentSheet);
			}
			
		}catch(SQLException se){
			new SQLError(se);
		}
		
		return sheets;
	}
	
}
