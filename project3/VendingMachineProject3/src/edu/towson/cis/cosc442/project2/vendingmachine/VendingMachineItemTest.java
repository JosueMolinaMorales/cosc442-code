package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class VendingMachineItemTest {
    
    /**
     * Test for the constructor of the {@link VendingMachineItem} class.
     */
    @Test
    public void testVendingMachineItemDoesNotThrowExecption() {
        VendingMachineItem item = new VendingMachineItem("Coke", 1.25);
        assertEquals("Coke", item.getName());
        assertEquals(1.25, item.getPrice(), 0.001);
    }

    /**
     * Test for the constructor of the {@link VendingMachineItem} class.
     * Ensures that an exception is thrown when the cost of the item is < 0.
     */
    @Test(expected = VendingMachineException.class)
    public void testItemPriceIsLessThanZeroThrowsExecption() {
        new VendingMachineItem("Coke", -1.25);
    }

    /**
     * Test for the constructor of the {@link VendingMachineItem} class.
     * Ensures that an exception is thrown when the name is null
     */
    @Test
    public void testItemThrowsExceptionNameCannotBeNull() {
        try {
            new VendingMachineItem(null, 1.25);
            fail("Expected VendingMachineException");
        } catch (VendingMachineException e) {
            assertEquals("Name cannot be null", e.getMessage());
        }
    }
    
    /**
     * Test that the getName() method of the {@link VendingMachineItem} class
     * returns the correct name of the item.
     */
    @Test
    public void testGetName() {
        VendingMachineItem item = new VendingMachineItem("Coke", 1.25);
        assertEquals("Coke", item.getName());
    }

    /**
     * Test that the getPrice() method of the {@link VendingMachineItem} class
     * returns the correct price of the item.
     */
    @Test
    public void testGetPrice() {
        VendingMachineItem item = new VendingMachineItem("Coke", 1.25);
        assertEquals(1.25, item.getPrice(), 0.001);
    }
}
