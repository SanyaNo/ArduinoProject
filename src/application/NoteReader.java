package application;

import communication.ArduinoCom;

public class NoteReader {
	ArduinoCom comLine;
	private String currentLine;
	
	public NoteReader(ArduinoCom comLine){
		this.comLine =  comLine;
	}
	
	public void stop(){
		comLine.setRunning(false);
	}
	
	public void start(){
		
		comLine.setRunning(true);
		
		while (comLine.getRunning()) {
			 
			String note = comLine.getCurrentLine();

			if (!(note == null)) {

				if (!currentLine.equals(note)) {

					currentLine = note;
					// Note comparator logic
					System.out.println("Test");

				}

			}

		}
	}
	
	
	public String getCurrentLine(){
		return currentLine;
	}

}
