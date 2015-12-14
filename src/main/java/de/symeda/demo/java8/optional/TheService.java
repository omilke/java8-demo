package de.symeda.demo.java8.optional;

import java.util.Optional;

public class TheService {

	public String service(String value) {

		Optional<String> optionalString = Optional.ofNullable(value);

		return optionalString.orElseGet(() -> "the default value");
	}
}
