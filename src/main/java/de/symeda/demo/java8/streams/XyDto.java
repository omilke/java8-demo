package de.symeda.demo.java8.streams;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class XyDto {

	private Type type;

	private int occurrence;

	private LocalDateTime changeDate;

	private String uuid;

	private String notUniqueString;

	private BigDecimal value;

	public XyDto(Type type, int occurrence, LocalDateTime changeDate, String uuid, String notUniqueString) {
		this.type = type;
		this.occurrence = occurrence;
		this.changeDate = changeDate;
		this.uuid = uuid;
		this.notUniqueString = notUniqueString;
	}

	public XyDto(BigDecimal value) {
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public int getOccurrence() {
		return occurrence;
	}

	public LocalDateTime getChangeDate() {
		return changeDate;
	}

	public String getNotUniqueString() {
		return notUniqueString;
	}

	public String getUuid() {
		return uuid;
	}

	public BigDecimal getValue() {
		return value;
	}

}
