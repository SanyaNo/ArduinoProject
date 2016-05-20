package graphics;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


public class Toolbar extends JMenuBar implements ActionListener {
	
	private JMenu file;
	private MyButton start;
	private MyButton stop;
	
	public Toolbar(){
		
		setBorder(BorderFactory.createEtchedBorder());
		
		file = new JMenu("File");
		start = new MyButton("Start");
		stop = new MyButton("Stop");
		
		setLayout(new FlowLayout(FlowLayout.LEADING));
		
		add(file);
		
		add(start);
		
		add(stop);
		
	}//end constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}