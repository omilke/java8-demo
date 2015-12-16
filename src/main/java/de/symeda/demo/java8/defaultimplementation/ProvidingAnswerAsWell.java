package de.symeda.demo.java8.defaultimplementation;

public interface ProvidingAnswerAsWell {

	public default String displayAnswer() {

		return "A:";
	};

}
