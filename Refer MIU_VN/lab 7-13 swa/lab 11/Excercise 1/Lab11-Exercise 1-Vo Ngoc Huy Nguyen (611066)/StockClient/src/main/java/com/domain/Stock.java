package com.domain;

public class Stock {
	private String name;
	private double value;

	public Stock(String name, double value) {
		this.name = name;
		this.value = value;
	}

	public Stock() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String toString() {
		return "stock " + name + " has value " + value;
	}
}
