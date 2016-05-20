package graphics;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public interface LeftPanelListener extends ActionListener, MouseListener{
	
	public void nodeClicked(LeftPanelEvent event);

}
