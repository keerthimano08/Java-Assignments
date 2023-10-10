package org.abstraction;

public class Automation extends MultipleLanguage {

	public static void main(String[] args) {
		Automation obj = new Automation();
		obj.java();
		obj.selenium();
		obj.python();
		obj.ruby();
	}

	@Override
	public void ruby() {
		System.out.println("Ruby is another computer programming language");
	
	}

}
