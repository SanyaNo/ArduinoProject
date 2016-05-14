package graphics;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;

import communication.Dispatcher;
import data.Sheet;

public class LeftPanel extends JPanel {

	private JTree menu;

	public LeftPanel() {
		//TODO fit tree hierarchy
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Sheet");
		populateSheetNode(node);
		menu = new JTree(node);
		menu.setShowsRootHandles(true);

		Border innerBorder = BorderFactory.createTitledBorder("Menu");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		JScrollPane scroll = new JScrollPane(menu);
		scroll.setPreferredSize(new Dimension(150, 500));
		add(scroll, new FlowLayout());

	}

	public void populateSheetNode(DefaultMutableTreeNode node) {

		ArrayList<Sheet> sheet = Dispatcher.getSheets();
		for (Sheet sh : sheet) {

			node.add(new DefaultMutableTreeNode(sh.getName()));

		}
	}

}
