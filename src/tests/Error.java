package tests;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Error extends JFrame{
	
	public static void main(String[] args){
		Error err = new Error();
	}

	public Error() {
		
		ImageIcon imageIcon = new ImageIcon("D:/java/ArduinoProject/resources/pics/giphy.gif");
		JLabel label = new JLabel(imageIcon);
		setDefaultWindowProperties(label);

	}
	
	public void setDefaultWindowProperties(JLabel label){
		
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
		setSize(label.getWidth(), label.getHeight());
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
