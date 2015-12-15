package de.symeda.demo.java8.misc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class MapManipulationTest {

	@Test
	public void testGetValue() throws Exception {

		MapManipulation cut = new MapManipulation();

		//value not present -> get default value
		assertThat(cut.getValue("bad value"), is(comparesEqualTo(new BigDecimal(666L))));

		//but that did not insert the default, so we shall get the default again
		assertThat(cut.getValue("bad value"), is(comparesEqualTo(new BigDecimal(666L))));

		cut.manipulate("asd");
		assertThat(cut.getValue("asd"), is(comparesEqualTo(BigDecimal.ONE)));

		cut.manipulate("asd");
		assertThat(cut.getValue("asd"), is(comparesEqualTo(new BigDecimal(2L))));
	}

}
