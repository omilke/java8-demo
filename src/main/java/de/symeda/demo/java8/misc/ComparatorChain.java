package de.symeda.demo.java8.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorChain {

	public static class Container {

		private final int first;

		private final int second;

		public Container(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}

		public int getFirst() {
			return first;
		}

		public int getSecond() {
			return second;
		}

	}

	public List<Container> sort(List<Container> values) {

		Comparator<Container> compareFirst = Comparator.comparingInt(Container::getFirst);

		Comparator<Container> compareSecond = Comparator.comparingInt(Container::getSecond).reversed();

		List<Container> sortedCollection = new ArrayList<>(values);
		Collections.sort(sortedCollection, compareFirst.thenComparing(compareSecond));

		return sortedCollection;

	}
}
