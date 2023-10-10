package org.abstraction;

public abstract class MultipleLanguage implements TestTool {

	@Override
	public void java() {
		System.out.println("Java is a computer programming language");
	}

	@Override
	public void selenium() {
		System.out.println("Selenium is a test automation tool");
	}

	public void python() {
		System.out.println("Python is another computer programming language");
	}
	
	public abstract void ruby();
}
