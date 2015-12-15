package de.symeda.demo.java8.misc;

public class MathInvoker {

	public static int add(int x, int y) {
		return x + y;
	}

	public static int addExact(int x, int y) {

		return Math.addExact(x, y);
	}

}
