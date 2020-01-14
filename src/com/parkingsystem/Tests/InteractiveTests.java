package com.parkingsystem.Tests;
import org.junit.Test;

import com.parkingsystem.Controller.AutomatedSystem;
import com.parkingsystem.Models.SlotList;

import static org.junit.Assert.*;

import java.util.LinkedList;

public class InteractiveTests {

@Test
 public void testAssertions() {
	 SlotList slots=null;
	 slots=(SlotList)(AutomatedSystem.interactiveCommands(slots, "create_parking_lot 6"));
	 assertSame(slots.getSlots().length,6);
	 assertTrue((boolean)(AutomatedSystem.interactiveCommands(slots, "park KA-01-HH-1234 White")));
	 assertTrue((boolean)(AutomatedSystem.interactiveCommands(slots, "park KA-01-HH-9999 White")));
	 assertTrue((boolean)(AutomatedSystem.interactiveCommands(slots, "park KA-01-BB-0001 Black")));
	 assertTrue((boolean)(AutomatedSystem.interactiveCommands(slots, "park KA-01-HH-7777 Red")));
	 assertTrue((boolean)(AutomatedSystem.interactiveCommands(slots, "park KA-01-HH-2701 Blue")));
	 assertTrue((boolean)(AutomatedSystem.interactiveCommands(slots, "park KA-01-HH-3141 Black")));
	 assertSame((int)(AutomatedSystem.interactiveCommands(slots, "leave 4")),4);
	 assertSame(AutomatedSystem.interactiveCommands(slots, "status"),null);
	 assertTrue((boolean)(AutomatedSystem.interactiveCommands(slots, "park KA-01-P-333 White")));
	 assertFalse((boolean)(AutomatedSystem.interactiveCommands(slots, "park DL-12-AA-9999 White")));
	 LinkedList<String> actualRegNo=(LinkedList<String>)(AutomatedSystem.interactiveCommands(slots,"registration_numbers_for_cars_with_color White"));
	 LinkedList<String> expectedRegNo=new LinkedList<String>();
	 expectedRegNo.add("KA-01-HH-1234");
	 expectedRegNo.add("KA-01-HH-9999");
	 expectedRegNo.add("KA-01-P-333");
	 assertEquals(expectedRegNo, actualRegNo);
	 LinkedList<Integer> actualSlot=(LinkedList<Integer>)(AutomatedSystem.interactiveCommands(slots,"slot_numbers_for_cars_with_color White"));
	 LinkedList<Integer> expectedSlot=new LinkedList<Integer>();
	 expectedSlot.add(1);
	 expectedSlot.add(2);
	 expectedSlot.add(4);
	 assertEquals(6, (AutomatedSystem.interactiveCommands(slots,"slot_number_for_registraion_number KA-01-HH-3141")));
	 assertEquals(-1, (AutomatedSystem.interactiveCommands(slots,"slot_number_for_registraion_number MH-04-AY-1111")));
}
}
