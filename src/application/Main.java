package application;

import graphics.MyWindow;

public class Main {

	public static void main(String[] args) throws Exception {
		
		try {

			MyWindow window = new MyWindow();

			NoteReader reader = new NoteReader();
			reader.start();

		} catch (Exception e) {
			e.printStackTrace();
			new Error();
		}

	}
}
