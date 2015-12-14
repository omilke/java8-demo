package de.symeda.demo.java8.streams;

public enum Type {

	VALUE_A,
	VALUE_B,
	VALUE_C,
	VALUE_D,
	VALUE_E,
	VALUE_F;

	public String getLabel() {

		return this.name().toLowerCase();
	}
}
