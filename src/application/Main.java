package application;

import communication.SerialTest;

public class Main {

	public static void main(String[] args) throws Exception {
		SerialTest main = new SerialTest();
		main.initialize();
		main.setRunning(true);
		
		while(main.getRunning()){
			
			System.out.println(main.getCurrentLine());
			
		}
		System.out.println("Started");
	
	}
}
