package de.symeda.demo.java8.streams;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class XyDtoTest {

	@Test
	public void collectAllMatching() {

		List<XyDto> all = new ArrayList<>();

		all.add(new XyDto(Type.VALUE_A, 1, LocalDateTime.of(2026, 12, 15, 12, 00), "uuid-1", "a"));
		all.add(new XyDto(Type.VALUE_B, 2, LocalDateTime.of(2025, 12, 15, 12, 00), "uuid-2", "a"));
		all.add(new XyDto(Type.VALUE_C, 3, LocalDateTime.of(2024, 12, 15, 12, 00), "uuid-3", "b"));
		all.add(new XyDto(Type.VALUE_D, 4, LocalDateTime.of(2023, 12, 15, 12, 00), "uuid-4", "b"));
		all.add(new XyDto(Type.VALUE_E, 5, LocalDateTime.of(2022, 12, 15, 12, 00), "uuid-5", "b"));
		all.add(new XyDto(Type.VALUE_F, 6, LocalDateTime.of(2021, 12, 15, 12, 00), "uuid-6", "c"));
		all.add(new XyDto(Type.VALUE_A, 7, LocalDateTime.of(2020, 12, 15, 12, 00), "uuid-7", "c"));
		all.add(new XyDto(Type.VALUE_B, 8, LocalDateTime.of(2019, 12, 15, 12, 00), "uuid-8", "d"));
		all.add(new XyDto(Type.VALUE_C, 9, LocalDateTime.of(2018, 12, 15, 12, 00), "uuid-9", "d"));
		all.add(new XyDto(Type.VALUE_D, 10, LocalDateTime.of(2017, 12, 15, 12, 00), "uuid-10", "d"));
		all.add(new XyDto(Type.VALUE_E, 11, LocalDateTime.of(2016, 12, 15, 12, 00), "uuid-11", "d"));
		all.add(new XyDto(Type.VALUE_F, 12, LocalDateTime.of(2015, 12, 15, 12, 00), "uuid-12", "e"));

		// @formatter:off
		List<XyDto> collected = all.stream()
			.filter(c -> c.getType() == Type.VALUE_A)
			.collect(Collectors.toList());
		// @formatter:on

		assertThat(collected, contains(all.get(0), all.get(6)));

	}

	@Test
	public void countAllMatching() {

		List<XyDto> all = new ArrayList<>();

		all.add(new XyDto(Type.VALUE_B, 1, LocalDateTime.of(2026, 12, 15, 12, 00), "uuid-1", "a"));
		all.add(new XyDto(Type.VALUE_A, 2, LocalDateTime.of(2025, 12, 15, 12, 00), "uuid-2", "a"));
		all.add(new XyDto(Type.VALUE_B, 3, LocalDateTime.of(2024, 12, 15, 12, 00), "uuid-3", "b"));
		all.add(new XyDto(Type.VALUE_A, 4, LocalDateTime.of(2023, 12, 15, 12, 00), "uuid-4", "b"));
		all.add(new XyDto(Type.VALUE_B, 5, LocalDateTime.of(2022, 12, 15, 12, 00), "uuid-5", "b"));
		all.add(new XyDto(Type.VALUE_A, 6, LocalDateTime.of(2021, 12, 15, 12, 00), "uuid-6", "c"));
		all.add(new XyDto(Type.VALUE_B, 7, LocalDateTime.of(2020, 12, 15, 12, 00), "uuid-7", "c"));
		all.add(new XyDto(Type.VALUE_A, 8, LocalDateTime.of(2019, 12, 15, 12, 00), "uuid-8", "d"));
		all.add(new XyDto(Type.VALUE_B, 9, LocalDateTime.of(2018, 12, 15, 12, 00), "uuid-9", "d"));
		all.add(new XyDto(Type.VALUE_A, 10, LocalDateTime.of(2017, 12, 15, 12, 00), "uuid-10", "d"));
		all.add(new XyDto(Type.VALUE_B, 11, LocalDateTime.of(2016, 12, 15, 12, 00), "uuid-11", "d"));
		all.add(new XyDto(Type.VALUE_A, 12, LocalDateTime.of(2015, 12, 15, 12, 00), "uuid-12", "e"));

		// @formatter:off
		long count = all.stream()
			.filter(c -> c.getType() == Type.VALUE_A)
			.count();
		// @formatter:on

		assertThat(count, is(6L));
	}

	@Test
	public void get10SortedByChangeDateWithMatchingType() {

		List<XyDto> all = new ArrayList<>();

		all.add(new XyDto(Type.VALUE_B, 1, LocalDateTime.of(2026, 12, 15, 12, 00), "uuid-1", "a"));
		all.add(new XyDto(Type.VALUE_A, 2, LocalDateTime.of(2025, 12, 15, 12, 00), "uuid-2", "a"));
		all.add(new XyDto(Type.VALUE_B, 3, LocalDateTime.of(2024, 12, 15, 12, 00), "uuid-3", "b"));
		all.add(new XyDto(Type.VALUE_A, 4, LocalDateTime.of(2023, 12, 15, 12, 00), "uuid-4", "b"));
		all.add(new XyDto(Type.VALUE_B, 5, LocalDateTime.of(2022, 12, 15, 12, 00), "uuid-5", "b"));
		all.add(new XyDto(Type.VALUE_A, 6, LocalDateTime.of(2021, 12, 15, 12, 00), "uuid-6", "c"));
		all.add(new XyDto(Type.VALUE_B, 7, LocalDateTime.of(2020, 12, 15, 12, 00), "uuid-7", "c"));
		all.add(new XyDto(Type.VALUE_A, 8, LocalDateTime.of(2019, 12, 15, 12, 00), "uuid-8", "d"));
		all.add(new XyDto(Type.VALUE_B, 9, LocalDateTime.of(2018, 12, 15, 12, 00), "uuid-9", "d"));
		all.add(new XyDto(Type.VALUE_A, 10, LocalDateTime.of(2017, 12, 15, 12, 00), "uuid-10", "d"));
		all.add(new XyDto(Type.VALUE_B, 11, LocalDateTime.of(2016, 12, 15, 12, 00), "uuid-11", "d"));
		all.add(new XyDto(Type.VALUE_A, 12, LocalDateTime.of(2015, 12, 15, 12, 00), "uuid-12", "e"));

		// @formatter:off
		List<XyDto> collected = all.stream()
			.filter(c -> c.getType() == Type.VALUE_A)
			.sorted(Comparator.comparing(XyDto::getChangeDate))
			.limit(5)
			.collect(Collectors.toList());
		// @formatter:on

		assertThat(collected, contains(all.get(11), all.get(9), all.get(7), all.get(5), all.get(3)));

	}

	@Test
	public void collectFirst3String() {

		List<XyDto> all = new ArrayList<>();

		all.add(new XyDto(Type.VALUE_A, 1, LocalDateTime.now(), "uuid-1", "a"));
		all.add(new XyDto(Type.VALUE_B, 2, LocalDateTime.now(), "uuid-2", "a"));
		all.add(new XyDto(Type.VALUE_C, 3, LocalDateTime.now(), "uuid-3", "b"));
		all.add(new XyDto(Type.VALUE_D, 4, LocalDateTime.now(), "uuid-4", "b"));
		all.add(new XyDto(Type.VALUE_E, 5, LocalDateTime.now(), "uuid-5", "b"));
		all.add(new XyDto(Type.VALUE_F, 6, LocalDateTime.now(), "uuid-6", "c"));
		all.add(new XyDto(Type.VALUE_A, 7, LocalDateTime.now(), "uuid-7", "c"));
		all.add(new XyDto(Type.VALUE_B, 8, LocalDateTime.now(), "uuid-8", "d"));
		all.add(new XyDto(Type.VALUE_C, 9, LocalDateTime.now(), "uuid-9", "d"));
		all.add(new XyDto(Type.VALUE_D, 10, LocalDateTime.now(), "uuid-10", "d"));
		all.add(new XyDto(Type.VALUE_E, 11, LocalDateTime.now(), "uuid-11", "d"));
		all.add(new XyDto(Type.VALUE_F, 12, LocalDateTime.now(), "uuid-12", "e"));

		// @formatter:off
		List<String> first3 = all.stream()
			.map(XyDto::getNotUniqueString)
			.distinct()
			.sorted()
			.limit(3)
			.collect(Collectors.toList());
		// @formatter:on

		assertThat(first3, contains("a", "b", "c"));
	}

	@Test
	public void collectHighestChangeDate() {

		List<XyDto> all = new ArrayList<>();

		all.add(new XyDto(Type.VALUE_A, 1, LocalDateTime.of(2015, 12, 15, 12, 00), "uuid-1", "this"));
		all.add(new XyDto(Type.VALUE_C, 2, LocalDateTime.of(2016, 12, 15, 12, 00), "uuid-2", "this"));

		// @formatter:off
		LocalDateTime localDateTime = all.stream()
			.map(XyDto::getChangeDate)
			.max(Comparator.naturalOrder())
			.get();
		// @formatter:on

		assertThat(localDateTime, is(comparesEqualTo(LocalDateTime.of(2016, 12, 15, 12, 00))));
	}

	@Test
	public void findSpecialValue() {

		List<XyDto> all = new ArrayList<>();

		all.add(new XyDto(Type.VALUE_A, 1, LocalDateTime.now(), "uuid-1", "this"));
		all.add(new XyDto(Type.VALUE_C, 2, LocalDateTime.now(), "uuid-2", "this"));

		// @formatter:off
		Optional<XyDto> first = all.stream()
			.filter(c -> c.getUuid().equals("uuid-2"))
			.findFirst();
		// @formatter:on

		assertThat(first.isPresent(), is(true));
		assertThat(first.get(), is(sameInstance(all.get(1))));
	}

	@Test
	public void joinDistinctPresentType() {

		List<XyDto> all = new ArrayList<>();

		all.add(new XyDto(Type.VALUE_A, 1, LocalDateTime.now(), "uuid-1", "this"));
		all.add(new XyDto(Type.VALUE_A, 2, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_C, 2, LocalDateTime.now(), "uuid-2", "this"));

		// @formatter:off
		String collect = all.stream()
			.map(XyDto::getType)
			.distinct()
			.map(Type::getLabel)
			.collect(Collectors.joining(", ", "<<", ">>"));
		// @formatter:on

		assertThat(collect, is(equalTo("<<value_a, value_c>>")));
	}

	@Test
	public void sumByType() {

		List<XyDto> all = new ArrayList<>();

		all.add(new XyDto(Type.VALUE_A, 1, LocalDateTime.now(), "uuid-1", "this"));
		all.add(new XyDto(Type.VALUE_A, 2, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_A, 3, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_B, -1, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_B, 1, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_C, 42, LocalDateTime.now(), "uuid-2", "this"));

		// @formatter:off
		Map<Type, Integer> collect = all
			.stream()
			.collect(Collectors.groupingBy(XyDto::getType, Collectors.summingInt(XyDto::getOccurrence)));
		// @formatter:on

		assertThat(collect.size(), is(3));
		assertThat(collect, hasEntry(Type.VALUE_A, 6));
		assertThat(collect, hasEntry(Type.VALUE_B, 0));
		assertThat(collect, hasEntry(Type.VALUE_C, 42));
	}

	@Test
	public void groupByType() {

		List<XyDto> all = new ArrayList<>();

		all.add(new XyDto(Type.VALUE_A, 1, LocalDateTime.now(), "uuid-1", "this"));
		all.add(new XyDto(Type.VALUE_A, 2, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_A, 3, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_B, -1, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_B, 1, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_C, 42, LocalDateTime.now(), "uuid-2", "this"));

		// @formatter:off
		Map<Type, List<XyDto>> collect = all
			.stream()
			.collect(Collectors.groupingBy(XyDto::getType));
		// @formatter:on

		assertThat(collect.size(), is(3));
		assertThat(collect.get(Type.VALUE_A), contains(all.get(0), all.get(1), all.get(2)));
		assertThat(collect.get(Type.VALUE_B), contains(all.get(3), all.get(4)));
		assertThat(collect.get(Type.VALUE_C), contains(all.get(5)));
	}

	private static class IntHolder {

		private int a = 0;
	}

	@Test
	public void filterAndPerformForEach() {

		List<XyDto> all = new ArrayList<>();

		all.add(new XyDto(Type.VALUE_A, 1, LocalDateTime.now(), "uuid-1", "this"));
		all.add(new XyDto(Type.VALUE_A, 2, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_A, 3, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_B, -1, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_B, 1, LocalDateTime.now(), "uuid-2", "this"));
		all.add(new XyDto(Type.VALUE_C, 42, LocalDateTime.now(), "uuid-2", "this"));

		IntHolder value = new IntHolder();

//		int a = 0;

		// @formatter:off
		all
			.stream()
			.filter(c -> c.getType() == Type.VALUE_A)
			.forEach(c -> {
				value.a += c.getOccurrence();
				
				System.out.println(c.getOccurrence());
				
//				a += c.getOccurrence();
			});
		// @formatter:on

		assertThat(value.a, is(6));
	}

	@Test
	public void reduceValue() {

		List<XyDto> all = new ArrayList<>();

		all.add(new XyDto(BigDecimal.valueOf(1L)));
		all.add(new XyDto(BigDecimal.valueOf(2L)));
		all.add(new XyDto(BigDecimal.valueOf(3L)));
		all.add(new XyDto(BigDecimal.valueOf(4L)));
		all.add(new XyDto(BigDecimal.valueOf(5L)));

		// @formatter:off
		BigDecimal reduce = all
			.stream()
//			.parallel()
			.map(XyDto::getValue)
			.reduce(BigDecimal.ONE, (f, s) -> {
				final BigDecimal result = f.multiply(s);
				System.out.println(String.format("%s * %s = %s", f.toString(), s.toString(), result.toString()));
				return result;
			});
		// @formatter:on

		assertThat(reduce, is(comparesEqualTo(BigDecimal.valueOf(120L))));
	}

	@Test
	public void intStream() {

		StringBuilder sb = new StringBuilder();

		IntStream.range(0, 10).forEach(c -> {

			sb.append(c);
		});

		assertThat(sb.toString(), is(equalTo("0123456789")));
	}

	@Test
	public void arrayToStream() {

		XyDto[] array = new XyDto[] {
				new XyDto(Type.VALUE_B, 1, LocalDateTime.now(), "uuid-2", "this"),
				new XyDto(Type.VALUE_B, -1, LocalDateTime.now(), "uuid-2", "this"),
				new XyDto(Type.VALUE_C, 42, LocalDateTime.now(), "uuid-2", "this"),
				new XyDto(Type.VALUE_A, 1, LocalDateTime.now(), "uuid-1", "this"),
				new XyDto(Type.VALUE_A, 2, LocalDateTime.now(), "uuid-2", "this"),
				new XyDto(Type.VALUE_A, 3, LocalDateTime.now(), "uuid-2", "this") };

		Set<Type> types = Arrays.stream(array).map(XyDto::getType).collect(Collectors.toCollection(TreeSet::new));

		assertThat(types, contains(Type.VALUE_A, Type.VALUE_B, Type.VALUE_C));

	}
}
