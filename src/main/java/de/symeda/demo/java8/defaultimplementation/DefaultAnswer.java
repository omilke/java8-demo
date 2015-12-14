package de.symeda.demo.java8.defaultimplementation;

public class DefaultAnswer implements TheInterface /* , TheSecondInterface */{

	@Override
	public String getAnswer() {

		return "42";
	}

}
