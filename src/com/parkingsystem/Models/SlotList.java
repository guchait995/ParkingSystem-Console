package com.parkingsystem.Models;

import java.util.LinkedList;
import java.util.List;

public class SlotList {
	 private Slot[] slots;
	 public SlotList(int size) {
		 slots=new Slot[size];
		 for(int i=0;i<slots.length;i++) {
			 slots[i]=new Slot(i+1);
		 }
		 System.out.println(String.format("Created a Parking lot with %d slots ", size)) ;
	 }
	
	 public Slot[] getSlots() {
		 	return slots;
	 }
	 
	 public Slot getSlotByNumber(int slotNumber) {
		 for(int i=0;i<slots.length;i++) {
			 if(slots[i].getSlotNumber()==slotNumber)
				 return slots[i];
		 }
		 return null;
	 }
	 
	 //add a car to parking lot with nearest position to entry gate
	 public boolean addCarToSlots(Car car) {
		 for(int i=0;i<slots.length;i++) {
			 if(slots[i].getCar()==null) {
				 //its empty
				 slots[i].setCar(car);
				 System.out.println("Allocated slot number :"+slots[i].getSlotNumber());
				 return true;
			 }
		 }
		 System.out.println("Sorry, Parking lot is full.");
		 //if no space empty
		 return false;
	 }
	 
	 //removes specific car from the slot and reassigns it null
	 public int removeCarFromSlots(int slotNumber) {
		 Slot slot=getSlotByNumber(slotNumber);
		 slot.setCar(null);
		 System.out.println(String.format("Slot number %d is Free",slot.getSlotNumber()));
		 return slot.getSlotNumber();
	 }
	 
	 //returns a list of car of same color 
	 //Input specs : choice can any integer
	 //if 0 it implies - Registration Number
	 //else it emplies - slot number	 
	 public List findRegistraionNumberOrSlotNumberByColor(String color,int choice) {
		 List slotsOrRegs=choice==0?new LinkedList<Integer>():new LinkedList<String>();
		 for(int i=0;i<slots.length;i++) {
			 Car c=slots[i].getCar();
			 if(c!=null && c.getColor().equalsIgnoreCase(color)) {
				if(choice==0) {
					System.out.print(i>0?" ,"+c.getCarNo():c.getCarNo());
					slotsOrRegs.add(c.getCarNo());
				}else {
					System.out.print(i>0?" ,"+slots[i].getSlotNumber():slots[i].getSlotNumber());
					slotsOrRegs.add(slots[i].getSlotNumber());
				}
			 }
		 }
		 System.out.println();
		 return slotsOrRegs;
	 }
	
	 //helps in finding slot with which specific cars is asscociated
	 public int findCarSlotByRegistration(String carNo) {
		 for(int i=0;i<slots.length;i++) {
			 Car c=slots[i].getCar();
			 if(c!=null && c.getCarNo().equalsIgnoreCase(carNo)) {
				 return slots[i].getSlotNumber();
			 }
		 }
		 return -1;
	 }
	 
	 //helps to view status of the parking lot
	 public void viewStatus() {
		 System.out.println(String.format("%s\t%s\t\t%s", "Slot No.","Registrtion No.","Color"));
		 for(int i=0;i<slots.length;i++) {
			 Car car=slots[i].getCar();
			 if(car!=null) {
				 System.out.println(String.format("%s\t\t%s\t\t%s", String.valueOf(slots[i].getSlotNumber()),car.getCarNo(),car.getColor()));
			 }
		 }
	 }

}
