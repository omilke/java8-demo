package de.symeda.demo.java8.misc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MathInvokerTest {

	@Test
	public void sumShouldNegative() {

		int sum = MathInvoker.add(Integer.MAX_VALUE, 1);
		assertThat(sum, is(Integer.MIN_VALUE));

	}

	@Test(expected = ArithmeticException.class)
	public void overflowShouldBeDetected() {

		MathInvoker.addExact(Integer.MAX_VALUE, 1);
	}

}
