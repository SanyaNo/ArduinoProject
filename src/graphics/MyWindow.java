package graphics;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyWindow extends JFrame {
	
	private LeftPanel panel;
	private Toolbar toolbar;

	public MyWindow() {
		
		super("Arduino Project");
		setNumbusLookAndFeel();
		
		//TODO create elements
		panel = new LeftPanel();
		toolbar = new Toolbar();
		setDefaultWindowProperties();
		
		//TODO add elements
		
		add(toolbar, BorderLayout.NORTH);
		add(panel, BorderLayout.WEST);
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
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public void setIcon(){
		this.setIconImage(new ImageIcon("./resources/pics/icon.png").getImage());
	}

}
