package tools;

import java.awt.Container;

import graphics.MyWindow;



public class Utilities {
	
	
	public Utilities() {
		// TODO Auto-generated constructor stub
	}
	
	public static Container getMainWinInstance(Container tmp){
		tmp = tmp.getParent();
		if (!(tmp instanceof MyWindow)){
			
			getMainWinInstance(tmp);
			
		}
		return tmp;
	}

}
