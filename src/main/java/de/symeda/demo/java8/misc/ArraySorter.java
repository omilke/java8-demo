package de.symeda.demo.java8.misc;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ArraySorter {

	private final int[] numbers = new int[1_000_000];
	private final int[] numbers_2 = new int[1_000_000];

	public void initAndSort() {

		Random random = new Random(System.currentTimeMillis());

		AtomicInteger index = new AtomicInteger(0);
		random.ints(numbers.length).forEach(i -> {

			numbers[index.get()] = i;
			numbers_2[index.getAndIncrement()] = i;
		});

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
