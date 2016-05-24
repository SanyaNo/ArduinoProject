package graphics;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class MyWindow extends JFrame {
	
	private LeftPanel panel;
	private Toolbar toolbar;
	private SheetArea sheetArea;
	
	

	public MyWindow() {
		
		super("Arduino Project");
		setNumbusLookAndFeel();
		
		//TODO create elements
		panel = new LeftPanel();
		toolbar = new Toolbar();
		sheetArea = new SheetArea();
		
		setDefaultWindowProperties();
		
		//TODO add elements
		
		add(toolbar, BorderLayout.NORTH);
		add(panel, BorderLayout.WEST);
		add(new JScrollPane(sheetArea), BorderLayout.CENTER);
		
	}
	
	public void setNumbusLookAndFeel(){
		 try {
		        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		            if ("Nimbus".equals(info.getName())) {
		                UIManager.setLookAndFeel(info.getClassName());
		                break;
		            }
		        }
		    } catch (UnsupportedLookAndFeelException e) {
		        // handle exception
		    } catch (ClassNotFoundException e) {
		        // handle exception
		    } catch (InstantiationException e) {
		        // handle exception
		    } catch (IllegalAccessException e) {
		        // handle exception
		    }
	}
	
	
	public void setDefaultWindowProperties(){
		
		
		setIcon();
		setLayout(new BorderLayout());
		pack();
		setSize(1000, 800);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public void setIcon(){
		this.setIconImage(new ImageIcon("./resources/pics/icon.png").getImage());
	}

	public LeftPanel getPanel() {
		return panel;
	}

	public void setPanel(LeftPanel panel) {
		this.panel = panel;
	}

	public Toolbar getToolbar() {
		return toolbar;
	}

	public void setToolbar(Toolbar toolbar) {
		this.toolbar = toolbar;
	}

	public SheetArea getSheetArea() {
		return sheetArea;
	}

	public void setSheetArea(SheetArea sheetArea) {
		this.sheetArea = sheetArea;
	}

}
