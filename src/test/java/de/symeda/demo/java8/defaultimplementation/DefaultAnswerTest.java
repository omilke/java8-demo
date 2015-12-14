package de.symeda.demo.java8.defaultimplementation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DefaultAnswerTest {

	@Test
	public void testName() {

		DefaultAnswer cut = new DefaultAnswer();

		assertThat(cut.theMethod(), is(equalTo(TheInterface.ANSWER_IS + "42")));
	}

}
