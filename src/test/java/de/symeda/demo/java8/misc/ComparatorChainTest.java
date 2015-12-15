package de.symeda.demo.java8.misc;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.symeda.demo.java8.misc.ComparatorChain.Container;

public class ComparatorChainTest {

	@Test
	public void testSort() throws Exception {

		List<ComparatorChain.Container> values = new ArrayList<>();

		values.add(new Container(2, 1));
		values.add(new Container(2, 3));
		values.add(new Container(2, 2));

		values.add(new Container(1, 1));
		values.add(new Container(1, 2));
		values.add(new Container(1, 3));

		List<Container> sorted = new ComparatorChain().sort(values);

		assertThat(sorted.get(0), sameInstance(values.get(5)));
		assertThat(sorted.get(1), sameInstance(values.get(4)));
		assertThat(sorted.get(2), sameInstance(values.get(3)));

		assertThat(sorted.get(3), sameInstance(values.get(1)));
		assertThat(sorted.get(4), sameInstance(values.get(2)));
		assertThat(sorted.get(5), sameInstance(values.get(0)));

	}

}
