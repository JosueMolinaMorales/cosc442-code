package game;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import asciiPanel.AsciiPanel;

public class InventoryTest {
    final static int MAX_INVENTORY_SIZE = 10;
    Inventory inventory;
    Item item;

    @Before
    public void setUp() throws Exception {
        inventory = new Inventory(MAX_INVENTORY_SIZE);
        item = new Item('a', AsciiPanel.black, "Name", "Red");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddItemSuccessfullyAddsAnItemToASlot() {
        inventory.add(item);
        // Assert that the item is in the first slot
        assertEquals(item, inventory.get(0));
        // Assert that all other slots are null
        for (int i = 1; i < MAX_INVENTORY_SIZE; i++) {
            assertEquals(null, inventory.get(i));
        }
    }

    @Test
    public void testAddItemDoesNotAddAnItemToAFullInventory() {
        // Fill the inventory
        for (int i = 0; i < MAX_INVENTORY_SIZE; i++) {
            inventory.add(item);
        }
        // Assert that the inventory is full
        assertEquals(true, inventory.isFull());
        // Try to add another item
        Item notAddedItem = new Item('b', AsciiPanel.black, "Name", "Red");
        inventory.add(notAddedItem);
        // Assert that the inventory does not contain the item
        assertFalse(inventory.contains(notAddedItem));
    }

    @Test
    public void testRemoveItemSuccessfully() {
        // Add an item to the inventory
        inventory.add(item);
        // Assert that the inventory contains the item
        assertEquals(true, inventory.contains(item));
        // Remove the item
        inventory.remove(item);
        // Assert that the inventory does not contain the item
        assertFalse(inventory.contains(item));
    }

    @Test
    public void testRemoveItemNotInInventory() {
    	Item notAddedItem = new Item('b', AsciiPanel.black, "Name", "Red");
    	inventory.remove(notAddedItem);
    	assertFalse(inventory.contains(notAddedItem));
    }
    
    @Test
    public void testIsFullReturnsTrueForAFullInventory() {
        // Fill the inventory
        for (int i = 0; i < MAX_INVENTORY_SIZE; i++) {
            inventory.add(item);
        }
        // Assert that the inventory is full
        assertTrue(inventory.isFull());
    }

    @Test
    public void testIsFullReturnsFalseForAnEmptyInventory() {
        // Assert that the inventory is not full
        assertFalse(inventory.isFull());
    }

    @Test
    public void testContainsReturnsTrueForAnItemInInventory() {
        // Add an item to the inventory
        inventory.add(item);
        // Assert that the inventory contains the item
        assertTrue(inventory.contains(item));
    }

    @Test
    public void testContainsReturnFalseForAnItemNotInInventory() {
        // Assert that the inventory does not contain the item
        assertFalse(inventory.contains(item));
    }
    
    @Test
    public void testGetItemsReturnsItemsList() {
    	// Fill the inventory
        for (int i = 0; i < MAX_INVENTORY_SIZE; i++) {
            inventory.add(item);
        }
        Item[] items = inventory.getItems();
        // Assert the items are the same
        for (int i = 0; i < items.length; i++) {
        	assertEquals(item, items[i]);
        }
    }
}
