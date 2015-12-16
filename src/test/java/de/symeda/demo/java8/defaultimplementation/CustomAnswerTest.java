package de.symeda.demo.java8.defaultimplementation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CustomAnswerTest {

	@Test
		public void testDisplayAnswer() throws Exception {
	
			CustomAnswer cut = new CustomAnswer();
	
			assertThat(cut.displayAnswer(), is(equalTo("A: 47 11")));
		}

}
