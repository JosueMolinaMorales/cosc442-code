package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
    VendingMachine vendingMachine;
    VendingMachineItem item;

    /**
     * Sets up the test fixture.
     */
    @Before
    public void setUp() {
        vendingMachine = new VendingMachine();
        item = new VendingMachineItem("Coke", 1.25);
    }

    /**
     * Tears down the test fixture.
     */
    @After
    public void tearDown() {
        vendingMachine = null;
        item = null;
    }

    /**
     * Test the addItem method of the {@link VendingMachine} class.
     * Ensures that item is added to the correct slot.
     */
    @Test
    public void testAddItemSuccessfullyAddsAnItemToASlot() {
        vendingMachine.addItem(item, "A");
        assertEquals(item, vendingMachine.getItem("A"));
    }

    /**
     * Test the addItem method of the {@link VendingMachine} class.
     * Ensures that item is added to the correct slot.
     */
    @Test
    public void testAddItemSuccessfullyAddsAnItemToBSlot() {
        vendingMachine.addItem(item, "B");
        assertEquals(item, vendingMachine.getItem("B"));
    }

    /**
     * Test the addItem method of the {@link VendingMachine} class.
     * Ensures that item is added to the correct slot.
     */
    @Test
    public void testAddItemSuccessfullyAddsAnItemToCSlot() {
        vendingMachine.addItem(item, "C");
        assertEquals(item, vendingMachine.getItem("C"));
    }

    /**
     * Test the addItem method of the {@link VendingMachine} class.
     * Ensures that item is added to the correct slot.
     */
    @Test
    public void testAddItemSuccessfullyAddsAnItemToDSlot() {
        vendingMachine.addItem(item, "D");
        assertEquals(item, vendingMachine.getItem("D"));
    }

    /**
     * Test the addItem method of the {@link VendingMachine} class.
     * Ensures that item is added to the correct slot.
     */
    @Test
    public void testAddItemThrowsExceptionForInvalidSlot() {
        try {
            vendingMachine.addItem(item, "E");
            fail("Expected VendingMachineException");
        } catch (VendingMachineException e) {
            assertEquals("Invalid code for vending machine item", e.getMessage());
        }
    }

    /**
     * Test the addItem method of the {@link VendingMachine} class.
     * Throws an exception when the slot is null.
     */
    @Test
    public void testAddItemThrowsExceptionForNullSlot() {
        try {
            vendingMachine.addItem(item, null);
            fail("Expected VendingMachineException");
        } catch (VendingMachineException e) {
            assertEquals("Code cannot be null", e.getMessage());
        }
    }

    /**
     * Test the addItem method of the {@link VendingMachine} class.
     * Throws an exception when the item is null.
     */
    @Test
    public void testAddItemThrowsExceptionForItemBeingNull() {
        try {
            vendingMachine.addItem(null, "A");
            fail("Expected VendingMachineException");
        } catch (VendingMachineException e) {
            assertEquals("Item cannot be null", e.getMessage());
        }
    }

    /**
     * Test the addItem method of the {@link VendingMachine} class.
     * Throws an exception when the slot is already occupied.
     */
    @Test
    public void testAddItemThrowsExceptionForSlotAlreadyOccupied() {
        vendingMachine.addItem(item, "A");
        try {
            vendingMachine.addItem(item, "A");
            fail("Expected VendingMachineException");
        } catch (VendingMachineException e) {
            assertEquals("Slot A already occupied", e.getMessage());
        }
    }

    /**
     * Test the getItem method of the {@link VendingMachine} class.
     * Ensures that the item is removed from the correct slot.
     */
    @Test
    public void testRemoveItemSuccessfullyRemovesItemFromASlot() {
        vendingMachine.addItem(item, "A");
        vendingMachine.removeItem("A");
        assertEquals(null, vendingMachine.getItem("A"));
    }

    /**
     * Test the getItem method of the {@link VendingMachine} class.
     * Ensures that the item is removed from the correct slot.
     */
    @Test
    public void testRemoveItemSuccessfullyRemovesItemFromBSlot() {
        vendingMachine.addItem(item, "B");
        vendingMachine.removeItem("B");
        assertEquals(null, vendingMachine.getItem("B"));
    }

    /**
     * Test the getItem method of the {@link VendingMachine} class.
     * Ensures that the item is removed from the correct slot.
     */
    @Test
    public void testRemoveItemSuccessfullyRemovesItemFromCSlot() {
        vendingMachine.addItem(item, "C");
        vendingMachine.removeItem("C");
        assertEquals(null, vendingMachine.getItem("C"));
    }

    /**
     * Test the getItem method of the {@link VendingMachine} class.
     * Ensures that the item is removed from the correct slot.
     */
    @Test
    public void testRemoveItemSuccessfullyRemovesItemFromDSlot() {
        vendingMachine.addItem(item, "D");
        vendingMachine.removeItem("D");
        assertEquals(null, vendingMachine.getItem("D"));
    }

    /**
     * Test the getItem method of the {@link VendingMachine} class.
     * Throws an exception when the slot is already empty.
     */
    @Test
    public void testRemoveItemThrowsExceptionForSlotAlreadyEmpty() {
        try {
            vendingMachine.removeItem("A");
            fail("Expected VendingMachineException");
        } catch (VendingMachineException e) {
            assertEquals("Slot A is empty -- cannot remove item", e.getMessage());
        }
    }

    /**
     * Test the insertMoney method of the {@link VendingMachine} class.
     * Ensures that the correct amount is added to the balance.
     */
    @Test
    public void testInsertMoneySuccessfullyAddsMoneyToBalance() {
        vendingMachine.insertMoney(1.00);
        assertEquals(1.00, vendingMachine.getBalance(), 0.001);
    }

    /**
     * Test the insertMoney method of the {@link VendingMachine} class.
     * Throws an exception when the amount is negative.
     */
    @Test
    public void testInsertMoneyThrowsExceptionForNegativeAmount() {
        try {
            vendingMachine.insertMoney(-1.00);
            fail("Expected VendingMachineException");
        } catch (VendingMachineException e) {
            assertEquals("Invalid amount.  Amount must be >= 0", e.getMessage());
        }
    }

    /**
     * Test the getBalance method of the {@link VendingMachine} class.
     * Ensures that the correct balance is returned.
     */
    @Test
    public void testGetBalanceReturnsCorrectBalance() {
        vendingMachine.insertMoney(1.00);
        assertEquals(1.00, vendingMachine.getBalance(), 0.001);
    }

    /**
     * Test the makePurchase method of the {@link VendingMachine} class.
     * Ensures that the balance is correct after a purchase.
     * Ensures that the item is removed from the correct slot.
     */
    @Test
    public void testMakePurchaseSuccessfullyPurchasesItem() {
        vendingMachine.addItem(item, "A");
        vendingMachine.insertMoney(1.25);
        vendingMachine.makePurchase("A");
        assertEquals(0.00, vendingMachine.getBalance(), 0.001);
        assertEquals(null, vendingMachine.getItem("A"));
    }

    /**
     * Test the makePurchase method of the {@link VendingMachine} class.
     * Throws an exception when the code is null.
     */
    @Test
    public void testMakePurchaseThrowsExceptionForNullSlot() {
        try {
            vendingMachine.makePurchase(null);
            fail("Expected VendingMachineException");
        } catch (VendingMachineException e) {
            assertEquals("Code cannot be null", e.getMessage());
        }
    }

    /**
     * Test the makePurchase method of the {@link VendingMachine} class.
     * Returns false when there is not enough money.
     */
    @Test
    public void testMakePurchaseReturnsFalseForNotEnoughMoney() {
        vendingMachine.addItem(item, "A");
        vendingMachine.insertMoney(1.00);
        assertEquals(false, vendingMachine.makePurchase("A"));
    }

    /**
     * Test the makePurchase method of the {@link VendingMachine} class.
     * Returns false when the slot is empty.
     */
    @Test
    public void testMakePurchaseReturnsFalseForEmptySlot() {
        vendingMachine.addItem(item, "A");
        vendingMachine.insertMoney(1.25);
        assertEquals(false, vendingMachine.makePurchase("B"));
    }

    /**
     * Test the returnChange method of the {@link VendingMachine} class.
     * Ensures that the correct change is returned.
     */
    @Test
    public void testReturnChangeReturnsCorrectChange() {
        vendingMachine.insertMoney(1.00);
        assertEquals(1.00, vendingMachine.returnChange(), 0.001);
    }

    /**
     * Test the returnChange method of the {@link VendingMachine} class.
     * Ensures that the balance is reset to zero.
     */
    @Test
    public void testReturnChangeResetsBalanceToZero() {
        vendingMachine.insertMoney(1.00);
        vendingMachine.returnChange();
        assertEquals(0.00, vendingMachine.getBalance(), 0.001);
    }

    /**
     * Test the returnChange method of the {@link VendingMachine} class.
     * Ensures that the correct change is returned after a purchase.
     */
    @Test
    public void testReturnChangeReturnsCorrectChangeAfterPurchase() {
        vendingMachine.addItem(item, "A");
        vendingMachine.insertMoney(1.25);
        vendingMachine.makePurchase("A");
        assertEquals(0.00, vendingMachine.returnChange(), 0.001);
    }
}
