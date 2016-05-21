package communication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Sheet;

public class Dispatcher {

	private static Connection connection = DatabaseConnection.getInstance().getConnection();
	
	
	public Dispatcher() {

	}

	public static ArrayList<Sheet> getSheets() {
		ArrayList<Sheet> sheets = new ArrayList<Sheet>();

		String sql = "select id, sheet from arduino_app.sheet";
		try {

			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				Sheet currentSheet = new Sheet();
				currentSheet.setId(result.getInt("id"));
				currentSheet.setName(result.getString("sheet"));
				sheets.add(currentSheet);
			}

		} catch (SQLException se) {
			new SQLError(se);
		}

		return sheets;
	}

	public static Sheet populateSheet(String name) {
		Sheet sheet = null;
		ResultSet result = null;

		String sql = "select n.id as pitch, n.note, n_d.note_name, n_s.sequence as position"
				+ " from sheet as s inner join  notes_sheets as n_s on s.id = n_s.sheet_id "
				+ "inner join note_duration as n_d on n_s.note_duration = n_d.id inner join note as n "
				+ "on n_s.note_id = n.id where s.sheet = ? order by position ASC;";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			// set params

			stm.setString(1, name);
			result = stm.executeQuery();
			
			while(result.next()){
				
			}
			
			
		} catch (SQLException se) {
			new SQLError(se);
		}

		return sheet;
	}
}
