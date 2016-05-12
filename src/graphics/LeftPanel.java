package graphics;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import communication.Dispatcher;
import data.Sheet;

public class LeftPanel extends JPanel {
	
	private JTree menu;
	
	/*public static void main (String[] args){
		LeftPanel panel = new LeftPanel();
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.WEST);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/
	
	public LeftPanel(){
		
		
	
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Sheet");
		populateSheetNode(node);
		menu = new JTree(node);
		menu.setShowsRootHandles(true);
		add(new JScrollPane(menu), BorderLayout.WEST);
		
		
		
	}
	
	public void populateSheetNode(DefaultMutableTreeNode node){
		
		ArrayList<Sheet> sheet = Dispatcher.getSheets();
		for(Sheet sh : sheet){
			
			node.add(new DefaultMutableTreeNode(sh.getName()));
			
		}
	}
	
	
}
