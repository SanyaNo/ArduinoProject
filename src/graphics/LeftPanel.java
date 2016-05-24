package graphics;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import communication.Dispatcher;
import data.Note;
import data.Sheet;

public class LeftPanel extends JPanel {

	private JTree menu;

	private Object selectedNode = "";

	private MyWindow win;

	public LeftPanel() {

		// TODO fit tree hierarchy

		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Sheets");
		populateSheetNode(node);
		menu = new JTree(node);
		menu.setShowsRootHandles(true);
		menu.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) menu.getLastSelectedPathComponent();

				/* if nothing is selected */
				if (node == null)
					return;

				/* retrieve the node that was selected */
				selectedNode = node.getUserObject();
				String title = selectedNode.toString();
				/* React to the node selection. */
				MyWindow win = (MyWindow) menu.getParent().getParent().getParent().getParent().getParent().getParent()
						.getParent();
				SheetArea sheetArea = win.getSheetArea();
				sheetArea.removeAll();
				ArrayList<Note> score = Dispatcher.getScore(title);
				if (!title.equals("Sheets")) sheetArea.paintScore(score, title);
				
				win.validate();
				win.repaint();

			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Menu");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		JScrollPane scroll = new JScrollPane(menu);
		add(scroll, new FlowLayout());

		scroll.setPreferredSize(new Dimension(150, 650));

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

}
