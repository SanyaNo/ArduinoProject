package application;

import javax.swing.JFrame;

import communication.ArduinoCom;

public class Main {

	private static String currentLine = "";

	public static void main(String[] args) throws Exception {

		ArduinoCom comLine = new ArduinoCom();
		comLine.initialize();
		

		// Get the damn thing to close

		getWindow();
		
		NoteReader reader = new NoteReader(comLine);
		reader.start();
		

		
		System.out.println("Started");

	}

	public static String getCurrentLine() {
		return currentLine;
	}

	public static void getWindow() {
		JFrame frame = new JFrame("Close");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
