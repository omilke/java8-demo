package de.symeda.demo.java8.defaultimplementation;

@FunctionalInterface
public interface ProvidingAnswer {

	String ANSWER_IS = "answer is ";

	default String displayAnswer() {

		return ANSWER_IS + this.getAnswer();
	}

	String getAnswer();

}
