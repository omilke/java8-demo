package de.symeda.demo.java8.defaultimplementation;

public class CustomAnswer implements ProvidingAnswer, ProvidingAnswerAsWell {

	@Override
	public String getAnswer() {

		return "47 11";
	}

	@Override
	public String displayAnswer() {

		return "A: " + getAnswer();
	}

}
