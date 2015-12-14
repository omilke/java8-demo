package de.symeda.demo.java8.optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TheServiceTest {

	@Test
	public void testService() throws Exception {

		TheService cut = new TheService();

		String service = cut.service(null);

		assertThat(service, is(equalTo("the default value")));
	}

}
