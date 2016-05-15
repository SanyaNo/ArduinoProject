package data;

import java.util.ArrayList;

public class Sheet {

	private int id;
	
	private String name;
	
	private String key = "";

	private String timeSignature = "";

	private int tempo = 0;

	private ArrayList<Note> notes = new ArrayList<Note>();
	
	public Sheet(){
		
	}

	public Sheet(int id, String name) {

		this.id = id;
		this.name = name;

	}// end constructor

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTimeSignature() {
		return timeSignature;
	}

	public void setTimeSignature(String timeSignature) {
		this.timeSignature = timeSignature;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public ArrayList<Note> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}

}
