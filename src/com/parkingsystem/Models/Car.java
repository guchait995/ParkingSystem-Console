package com.parkingsystem.Models;

public class Car {
	private String carNo;
	private String color;
	public Car(String carNo, String color) {
		this.carNo = carNo;
		this.color = color;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
