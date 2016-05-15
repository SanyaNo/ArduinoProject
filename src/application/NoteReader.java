package application;

import communication.ArduinoCom;

public class NoteReader {

	private ArduinoCom comLine = new ArduinoCom();
	private String currentLine = "empty";
	private String note = " ";

	public NoteReader() {
		
		comLine.initialize();
		
	}

	public void stop() {
		System.out.println("Stop method");
		comLine.setRunning(false);
	}

	public void start() throws NullPointerException {

		comLine.setRunning(true);
		System.out.println("Start method");

		while (comLine.isRunning()) {
			if (comLine.getCurrentLine() != null){
				note = comLine.getCurrentLine();
			}
			if (!currentLine.equals(note)) {

				currentLine = note;
			}

		}
	}

	public String getCurrentLine() {
		System.out.println("Stop method");
		return currentLine;
	}

}