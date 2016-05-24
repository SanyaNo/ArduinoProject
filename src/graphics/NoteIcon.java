package graphics;

import java.awt.Dimension;

import javax.swing.ImageIcon;

public class NoteIcon extends ImageIcon {
	
	private String path;
	
	
	public NoteIcon(String path){
		super(path);
		
		this.path = path;

	}
	
	public ImageIcon getSmaller(){
		return new ImageIcon((this.getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
	}
	
}
