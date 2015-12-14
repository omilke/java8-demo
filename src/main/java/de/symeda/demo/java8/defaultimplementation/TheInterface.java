package de.symeda.demo.java8.defaultimplementation;

@FunctionalInterface
public interface TheInterface {

	String ANSWER_IS = "answer is ";

	default String theMethod() {

		return ANSWER_IS + this.getAnswer();
	}

	String getAnswer();

}
