package application;

import data.Sheet;
import graphics.MyWindow;

public class Main {

	public static void main(String[] args) throws Exception {
		
		try {

			MyWindow window = new MyWindow();

			NoteReader reader = new NoteReader();
			
			//TODO get the sheet from the menu a.k.a. database
			Sheet sheet = new Sheet();
			
			NoteComparator compare = new NoteComparator(reader, sheet);
			compare.start();
			

		} catch (Exception e) {
			new Error();
			e.printStackTrace();
			
		}

	}
}
