package de.symeda.demo.java8.misc;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MapManipulation {

	private final Map<String, BigDecimal> map = new HashMap<>();

	public void manipulate(String value) {

		map.computeIfPresent(value, (t, u) -> u.add(BigDecimal.ONE));

		map.putIfAbsent(value, BigDecimal.ONE);
	}

	public BigDecimal getValue(String value) {

		return map.computeIfAbsent(value, v -> new BigDecimal(666L));
	}

}
