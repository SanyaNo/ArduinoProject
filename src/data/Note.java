package data;

public class Note {

	private String name;

	private int pitch;
	
	private int position;
	
	public String duration;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getPitch() {
		return pitch;
	}

	public void setPitch(int pitch) {
		this.pitch = pitch;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "Note [name=" + name + ", pitch=" + pitch + ", position=" + position + ", duration=" + duration + "]";
	}
	
}
