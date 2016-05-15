package application;

import data.Sheet;

public class NoteComparator {
	
	private NoteReader reader;
	
	private Sheet sheet;
	
	public NoteComparator(NoteReader reader, Sheet sheet){
		
		this.reader = reader;
		this.sheet = sheet;
		
	}
	
	public void start(){
		reader.start();
	}
	
	

}
