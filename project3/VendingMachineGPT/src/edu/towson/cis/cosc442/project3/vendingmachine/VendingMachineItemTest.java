package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

    // Test that a new VendingMachineItem can be created with a name and price
    @Test
    public void testCreateVendingMachineItem() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Coke", 1.50);
        assertEquals("Coke", item.getName());
        assertEquals(1.50, item.getPrice(), 0.001);
    }
    
    // Test that an exception is thrown when a negative price is passed to the constructor
    @Test(expected = VendingMachineException.class)
    public void testCreateVendingMachineItemWithNegativePrice() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Chips", -0.50);
    }
    
    // Test that the getName method returns the correct name
    @Test
    public void testGetName() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Candy", 0.75);
        assertEquals("Candy", item.getName());
    }
    
    // Test that the getPrice method returns the correct price
    @Test
    public void testGetPrice() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Gum", 0.25);
        assertEquals(0.25, item.getPrice(), 0.001);
    }

}

