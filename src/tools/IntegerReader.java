package tools;

public class IntegerReader {
	private int currentLine;
	private ArduinoIntCom comPort;
	private int note;

	public static void main(String[] args) {

		IntegerReader iReader = new IntegerReader();

		iReader.comPort.initialize();
		iReader.start();
	}

	public IntegerReader() {
		comPort = new ArduinoIntCom();
		currentLine = 0;
		note = 0;
	}

	public void start() {

		comPort.setRunning(true);
		System.out.println("Start method");

		while (comPort.isRunning()) {

			note = comPort.getCurrentLine();
			System.out.println(note);
		}
	}

}
