package de.symeda.demo.java8.methodreference;

import java.util.function.Function;

public class TheService {

	public String thePublicMethod(Object value, int x) {

		if (x < 42) {
			return this.complexMethod(value, this::doX);
		} else {
			return this.complexMethod(value, this::doY);
		}
	}

	private String complexMethod(Object value, Function<Object, String> converter) {

		//mighty many operations

		//and then
		return converter.apply(converter);

	}

	private String doX(Object value) {

		return value.toString();
	}

	private String doY(Object value) {

		return value.getClass().getName();
	}

}
