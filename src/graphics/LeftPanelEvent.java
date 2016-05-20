package graphics;

import java.util.EventObject;

public class LeftPanelEvent extends EventObject {
	
	private String sheet;
	
	public LeftPanelEvent(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public LeftPanelEvent(Object source, String sheet){
		super(source);
		this.sheet = sheet;
	}
	
	

}
