package de.symeda.demo.java8.defaultimplementation;

public class CustomAnswer implements TheInterface, TheSecondInterface {

	@Override
	public String getAnswer() {

		return "47 11";
	}

	@Override
	public String theMethod() {

		return "A: " + getAnswer();
	}

}
