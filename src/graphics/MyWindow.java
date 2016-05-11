package graphics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MyWindow extends JFrame {

	public MyWindow() {
		
		super("Arduino Project");
		setNumbusLookAndFeel();
		setDefaultWindowProperties();
		
		LeftPanel panel = new LeftPanel();
		setLayout(new BorderLayout());
		add(panel, BorderLayout.WEST);
		
		panel.add(new JLabel("Test"));
		
		
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
		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

}
