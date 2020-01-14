package com.parkingsystem.Controller;

import java.util.Scanner;

import com.parkingsystem.Models.Car;
import com.parkingsystem.Models.SlotList;

public class AutomatedSystem {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);	
		SlotList slots=null;
		while(true) {
			String input = scan.nextLine();
			interactiveCommands(slots, input);
		}
	}
	
	public static Object interactiveCommands(SlotList slots,String input) {
		try {
			String params[]=input.split(" ");
			switch(params[0]) {
			case "create_parking_lot" :{
				slots=new SlotList(Integer.parseInt(params[1]));
				return slots;
				}
				case "park": {
					Car car=new Car(params[1],params[2]);
					return slots.addCarToSlots(car); 
				}
				case "leave":{ 
					return slots.removeCarFromSlots(Integer.parseInt(params[1]));
					}
				case "status": {
					slots.viewStatus();
					return null;
					}
				case "registration_numbers_for_cars_with_color" : {
					return slots.findRegistraionNumberOrSlotNumberByColor(params[1],0);
					
					}
				case "slot_numbers_for_cars_with_color" : {
					return slots.findRegistraionNumberOrSlotNumberByColor(params[1],1);
					}
				case "slot_number_for_registraion_number" : {
					int slot=slots.findCarSlotByRegistration(params[1]);
					if(slot==-1) {
						System.out.println("Not found");
					}else {
						System.out.println(slot);
					}
					return slot;
					}
				default:{System.out.println("input error");}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
