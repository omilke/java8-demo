package de.symeda.demo.java8.misc;

import java.util.Arrays;
import java.util.Random;

public class ArraySorter {

	private final int[] numbers = new int[1_000_000];
	private final int[] numbers_2 = new int[1_000_000];

	public void initAndSort() {

		for (int i = 0; i < numbers.length; i++) {

			final int value = new Random().nextInt(Integer.MAX_VALUE);

			numbers[i] = value;
			numbers_2[i] = value;
		}

		this.parallelSort();
		this.sort();

	}

	protected void sort() {
		long time = System.currentTimeMillis();

		Arrays.sort(this.numbers);

		time = System.currentTimeMillis();

		System.out.println("sort: " + time);
	}

	protected void parallelSort() {

		long time = System.currentTimeMillis();

		Arrays.parallelSort(this.numbers_2);

		time = System.currentTimeMillis();

		System.out.println("sort: " + time);
	}
}
