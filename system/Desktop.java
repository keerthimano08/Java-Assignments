package org.system;

public class Desktop extends Computer{

	public void desktopSize() {
		System.out.println("Deskstop size is 14 Inches");
	}
	
	public static void main(String[] args) {
		Desktop obj = new Desktop();
		obj.desktopSize();
		obj.computerModel();
	}

}
