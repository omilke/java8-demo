package de.symeda.demo.java8.methodreference;

import java.util.function.Function;

public class NumberService {

	public String thePublicMethod(Number value, int x) {

		if (x < 42) {
			return this.complexMethod(value, this::doXStrategy);
		} else {
			return this.complexMethod(value, this::doYStrategy);
		}
	}

	private String complexMethod(Number value, Function<Number, String> converter) {

		//mighty many operations

		//and then
		return converter.apply(value);

	}

	private String doXStrategy(Number value) {

		return value.toString();
	}

	private String doYStrategy(Number value) {

		return value.getClass().getName();
	}

}
