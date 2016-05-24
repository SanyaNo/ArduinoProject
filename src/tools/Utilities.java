package tools;

import java.awt.Component;

import graphics.MyWindow;



public class Utilities {
	
	
	public Utilities() {
		// TODO Auto-generated constructor stub
	}
	
	public static MyWindow getMainWinInstance(Component tmp){
		tmp = tmp.getParent();
		if (tmp instanceof MyWindow == false){
			
			getMainWinInstance(tmp);
			
		}
		return (MyWindow)tmp;
	}

}
