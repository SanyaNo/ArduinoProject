package graphics;

import java.awt.Dimension;

import javax.swing.JButton;

public class MyButton extends JButton {
	
	public MyButton(String name){
		
		super(name);
		Dimension dm = new Dimension(70, 25);
		setPreferredSize(dm);
		
	}
}
