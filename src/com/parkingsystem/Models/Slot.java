package com.parkingsystem.Models;

public class Slot {
	private int slotNumber;
	private Car car;
	public Slot(int slotNumber) {
		this.slotNumber = slotNumber;
		this.car=null;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
}
