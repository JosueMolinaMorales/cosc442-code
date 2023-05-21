package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
    private VendingMachine vendingMachine;
    private VendingMachine fullVendingMachine;
    private VendingMachineItem item1;
    private VendingMachineItem item2;
    private VendingMachineItem item3;
    private VendingMachineItem item4;
    
    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
        fullVendingMachine = new VendingMachine();
        item1 = new VendingMachineItem("Chips", 1.50);
        item2 = new VendingMachineItem("Soda", 2.00);
        item3 = new VendingMachineItem("Item 3", 2.50);
        item4 = new VendingMachineItem("Item 4", 3.00);

        try {
        	fullVendingMachine.addItem(item1, "A");
        	fullVendingMachine.addItem(item2, "B");
        	fullVendingMachine.addItem(item3, "C");
        	fullVendingMachine.addItem(item4, "D");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

	@After
	public void tearDown() throws Exception {
	}

    @Test
    public void testConstructorCreatesEmptyItemArray() {
        VendingMachine vm = new VendingMachine();
        assertNull(vm.getItem("A"));
        assertNull(vm.getItem("B"));
        assertNull(vm.getItem("C"));
        assertNull(vm.getItem("D"));
    }
    
    @Test
    public void testConstructorInitializesBalanceToZero() {
        VendingMachine vm = new VendingMachine();
        assertEquals(0, vm.balance, 0.001);
    }
    
    @Test
    public void testAddItemValid() {
        try {
            vendingMachine.addItem(item1, "A");
            assertEquals(item1, vendingMachine.getItem("A"));
        } catch (VendingMachineException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testAddItemAlreadyOccupied() {
        try {
            vendingMachine.addItem(item1, "A");
            vendingMachine.addItem(item2, "A");
            fail("Expected exception was not thrown");
        } catch (VendingMachineException e) {
            assertEquals("Slot " + "A" + " already occupied", e.getMessage());
        }
    }
    
    @Test
    public void testAddItemInvalidCode() {
        try {
            vendingMachine.addItem(item1, "E");
            fail("Expected exception was not thrown");
        } catch (VendingMachineException e) {
            assertEquals("Invalid code for vending machine item", e.getMessage());
        }
    }
    
    @Test
    public void testGetItem() {
    	vendingMachine.addItem(item1, VendingMachine.A_CODE);
    	VendingMachineItem retrievedItem = vendingMachine.getItem(VendingMachine.A_CODE);
    	assertEquals(item1, retrievedItem);
    }
    
    @Test
    public void testGetItemEmptySlot() {
    	VendingMachineItem retrievedItem = vendingMachine.getItem(VendingMachine.A_CODE);
    	assertNull(retrievedItem);
    }
    
    @Test
    public void testThrowsForInvalidSlot() {
    	try {
    	    vendingMachine.getItem("E");
    	    fail("Expected VendingMachineException was not thrown");
    	} catch (VendingMachineException e) {
    	    assertEquals("Invalid code for vending machine item", e.getMessage());
    	}
    }
    
    @Test
    public void testRemoveItemSuccess() throws VendingMachineException {
        vendingMachine.addItem(item1, "A");
        vendingMachine.addItem(item2, "B");
        vendingMachine.addItem(item3, "C");
        vendingMachine.addItem(item4, "D");
        
        VendingMachineItem removedItem = vendingMachine.removeItem("A");
        assertEquals(item1, removedItem);
        
        removedItem = vendingMachine.removeItem("B");
        assertEquals(item2, removedItem);
        
        removedItem = vendingMachine.removeItem("C");
        assertEquals(item3, removedItem);
        
        removedItem = vendingMachine.removeItem("D");
        assertEquals(item4, removedItem);
    }
    
    @Test
    public void testRemoveItemEmptySlot() {
        try {
            vendingMachine.removeItem("A");
            fail("Expected VendingMachineException was not thrown.");
        } catch (VendingMachineException e) {
            assertEquals("Slot A is empty -- cannot remove item", e.getMessage());
        }
    }

    @Test
    public void testRemoveItemInvalidCode() {
        try {
            vendingMachine.removeItem("E");
            fail("Expected VendingMachineException was not thrown.");
        } catch (VendingMachineException e) {
            assertEquals("Invalid code for vending machine item", e.getMessage());
        }
    }
    
    @Test
	public void testInsertMoneyValidAmount() {
		VendingMachine vm = new VendingMachine();
		try {
			vm.insertMoney(1.50);
		} catch (VendingMachineException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
		assertEquals(1.50, vm.balance, 0.001);
	}

	@Test
	public void testInsertMoneyInvalidAmount() {
		VendingMachine vm = new VendingMachine();
		try {
			vm.insertMoney(-1.0);
			fail("Expected exception not thrown");
		} catch (VendingMachineException e) {
			assertEquals("Invalid amount.  Amount must be >= 0", e.getMessage());
			assertEquals(0.0, vm.balance, 0.001);
		}
	}
	
    @Test
    public void testGetBalanceEmptyVendingMachine() {
        VendingMachine vm = new VendingMachine();
        assertEquals(0.0, vm.getBalance(), 0.001);
    }
    
    @Test
    public void testGetBalanceNonEmptyVendingMachine() throws VendingMachineException {
        VendingMachine vm = new VendingMachine();
        VendingMachineItem item = new VendingMachineItem("Test Item", 1.25);
        vm.addItem(item, "A");
        vm.insertMoney(1.0);
        assertEquals(1.0, vm.getBalance(), 0.001);
    }
    
    @Test
    public void testMakePurchaseWithValidCodeAndEnoughMoney() {
    	fullVendingMachine.insertMoney(3.00);
        boolean result = fullVendingMachine.makePurchase("A");
        assertTrue(result);
        assertEquals(1.50, fullVendingMachine.getBalance(), 0.01);
        assertNull(fullVendingMachine.getItem("A"));
    }

    @Test
    public void testMakePurchaseWithValidCodeAndNotEnoughMoney() {
    	fullVendingMachine.insertMoney(1.00);
        boolean result = fullVendingMachine.makePurchase("B");
        assertFalse(result);
        assertEquals(1.00, fullVendingMachine.getBalance(), 0.01);
        assertNotNull(fullVendingMachine.getItem("B"));
    }

    @Test(expected = VendingMachineException.class)
    public void testMakePurchaseWithInvalidCode() {
        vendingMachine.makePurchase("E");
    }

    @Test
    public void testMakePurchaseWithEmptySlot() {
    	fullVendingMachine.insertMoney(3.00);
        fullVendingMachine.removeItem("A");
        boolean result = fullVendingMachine.makePurchase("A");
        assertFalse(result);
        assertEquals(3.00, fullVendingMachine.getBalance(), 0.01);
        assertNull(fullVendingMachine.getItem("A"));
    }

    @Test
    public void testMakePurchaseWithZeroBalance() {
    	fullVendingMachine.returnChange();
        boolean result = fullVendingMachine.makePurchase("A");
        assertFalse(result);
        assertEquals(0.00, fullVendingMachine.getBalance(), 0.01);
        assertNotNull(fullVendingMachine.getItem("A"));
    }
    
    @Test
    public void testMakePurchaseReturnsTrue() {
        try {
        	fullVendingMachine.insertMoney(2.50);
        } catch (VendingMachineException e) {
            e.printStackTrace();
        }
        assertTrue(fullVendingMachine.makePurchase("B"));
        assertEquals(0.50, fullVendingMachine.getBalance(), 0.001);
    }

    @Test
    public void testMakePurchaseReturnsFalseNotEnoughMoney() {
        try {
        	fullVendingMachine.insertMoney(1.00);
        } catch (VendingMachineException e) {
            e.printStackTrace();
        }
        assertFalse(fullVendingMachine.makePurchase("A"));
        assertEquals(1.00, fullVendingMachine.getBalance(), 0.001);
    }

    @Test
    public void testReturnChange() throws VendingMachineException {
        // Insert some money into the vending machine
        vendingMachine.insertMoney(2.50);
        
        // Return the change and verify that the correct amount is returned
        double change = vendingMachine.returnChange();
        assertEquals(2.50, change, 0.001);
        
        // Verify that the balance is now 0
        assertEquals(0.0, vendingMachine.getBalance(), 0.001);
    }
    
    @Test
    public void testReturnChangeNoMoneyInserted() {
        // Try to return change without inserting any money
        double change = vendingMachine.returnChange();
        assertEquals(0.0, change, 0.001);
        
        // Verify that the balance is still 0
        assertEquals(0.0, vendingMachine.getBalance(), 0.001);
    }

}
