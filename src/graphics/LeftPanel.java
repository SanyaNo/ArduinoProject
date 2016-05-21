package graphics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import communication.Dispatcher;
import data.Sheet;
import tests.Utilities;

public class LeftPanel extends JPanel {

	private JTree menu;
	
	private Object selectedNode = "";
	
	private LeftPanelListener lpl;
	
	private MyWindow win;

	public LeftPanel() {
		
		//TODO fit tree hierarchy
		
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Sheets");
		populateSheetNode(node);
		menu = new JTree(node);
		menu.setShowsRootHandles(true);
		menu.addTreeSelectionListener(new TreeSelectionListener() {
		    public void valueChanged(TreeSelectionEvent e) {
		        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
		                           menu.getLastSelectedPathComponent();

		    /* if nothing is selected */ 
		        if (node == null) return;

		    /* retrieve the node that was selected */ 
		        selectedNode = node.getUserObject();
		        
		    /* React to the node selection. */
		       Container win = menu.getParent().getParent().getParent().getParent().getParent().getParent().getParent();
		       win.add(new LeftPanel(), BorderLayout.EAST);
		       win.validate();
		       win.repaint();
		      
		    } 
		});
	
		

		Border innerBorder = BorderFactory.createTitledBorder("Menu");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		JScrollPane scroll = new JScrollPane(menu);
		scroll.setPreferredSize(new Dimension(150, 450));
		add(scroll, new FlowLayout());

	}

	public void populateSheetNode(DefaultMutableTreeNode node) {

		ArrayList<Sheet> sheet = Dispatcher.getSheets();
		for (Sheet sh : sheet) {

			node.add(new DefaultMutableTreeNode(sh.getName()));

		}
	}

	public Object getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(Object selectedNode) {
		this.selectedNode = selectedNode;
	}

	public LeftPanelListener getLpl() {
		return lpl;
	}

	public void setLpl(LeftPanelListener lpl) {
		this.lpl = lpl;
	}
	
}
