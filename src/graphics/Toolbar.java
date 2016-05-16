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
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 1;
		gc.weighty = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(file, gc);
		gc.insets = new Insets(0, 0, 0, 5);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(start, gc);
		gc.gridx = 2;
		add(stop, gc);
		
	}//end constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}