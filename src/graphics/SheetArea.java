package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import data.Note;

public class SheetArea extends JPanel {

	public SheetArea() {

		Dimension pDim = getPreferredSize();
		Dimension d = new Dimension(600, pDim.height);

		setPreferredSize(d);

		Border innerBorder = BorderFactory.createTitledBorder("Sheet");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		setBackground(Color.WHITE);
		repaint();
		revalidate();

	}

	public void paintScore(ArrayList<Note> score, String title) {

		JLabel sheet = new JLabel(title);
		int padding = 5 - (score.size() + 1) % 5;
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.weightx = 0;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 0);

		gc.gridx = 1;
		gc.gridy = 0;

		add(sheet, gc);

		gc.gridx = 1;
		gc.gridy = 1;

		NoteIcon sol = new NoteIcon("./resources/notes/sol.jpg");
		JLabel solIcon = new JLabel(sol.getSmaller());
		add(solIcon, gc);
		for (Note n : score) {

			if (gc.gridx % 5 == 0) {
				gc.gridx = 1;
				gc.gridy++;
			} else {
				gc.gridx++;
			}

			String path = "./resources/notes/" + n.getName() + " " + n.getDuration() + ".jpg";
			NoteIcon icon = new NoteIcon(path);
			JLabel label = new JLabel(icon.getSmaller());
			add(label, gc);
		}

		if (padding != 5) {
			String path = "./resources/notes/blank.jpg";

			for (int i = 0; i < padding; i++) {
				gc.gridx++;

				NoteIcon blank = new NoteIcon(path);
				JLabel blankLabel = new JLabel(blank.getSmaller());
				add(blankLabel, gc);
				
			}
		}

	}
}
