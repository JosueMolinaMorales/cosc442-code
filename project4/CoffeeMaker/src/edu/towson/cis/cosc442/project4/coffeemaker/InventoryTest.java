package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
	Inventory inv;

	@Before
	public void setUp() throws Exception {
		inv = new Inventory();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetChocolate() {
		assertEquals(15, inv.getChocolate());
	}

	@Test
	public void testSetChocolate() {
		inv.setChocolate(10);
		assertEquals(10, inv.getChocolate());
	}

	@Test
	public void testSetChocolateSetsToZero() {
		inv.setChocolate(-10);
		assertEquals(0, inv.getChocolate());
	}

	@Test
	public void testGetCoffee() {
		assertEquals(15, inv.getCoffee());
	}

	@Test
	public void testSetCoffeeSetsToZero() {
		inv.setCoffee(-10);
		assertEquals(0, inv.getCoffee());
	}

	@Test
	public void testSetCoffee() {
		inv.setCoffee(10);
		assertEquals(10, inv.getCoffee());
	}

	@Test
	public void testSetCoffeeToZero() {
		inv.setCoffee(-10);
		assertEquals(0, inv.getCoffee());
	}

	@Test
	public void testGetMilk() {
		inv.setMilk(10);
		assertEquals(10, inv.getMilk());
	}

	@Test
	public void testSetMilkSetsToZero() {
		inv.setMilk(-10);
		assertEquals(0, inv.getMilk());
	}

	@Test
	public void testSetMilk() {
		inv.setMilk(10);
		assertEquals(10, inv.getMilk());
	}

	@Test
	public void testGetSugar() {
		assertEquals(15, inv.getSugar());
	}

	@Test
	public void testSetSugar() {
		inv.setSugar(10);
		assertEquals(10, inv.getSugar());
	}

	@Test
	public void testSetSugarSetsToZero() {
		inv.setSugar(-10);
		assertEquals(0, inv.getSugar());
	}

	@Test
	public void testEnoughIngredients() {
		Recipe r1 = new Recipe();
		r1.setAmtChocolate(15);
		r1.setAmtCoffee(15);
		r1.setAmtMilk(15);
		r1.setAmtSugar(15);
		r1.setName("Coffee");
		r1.setPrice(50);
		assertTrue(inv.enoughIngredients(r1));
	}

	@Test
	public void testEnoughIngredientsReturnFalseForNotEnoughChocolate() {
		Recipe r1 = new Recipe();
		r1.setAmtChocolate(20);
		r1.setAmtCoffee(15);
		r1.setAmtMilk(15);
		r1.setAmtSugar(15);
		r1.setName("Coffee");
		r1.setPrice(50);
		assertFalse(inv.enoughIngredients(r1));
	}

	@Test
	public void testEnoughIngredientsReturnFalseForNotEnoughCoffee() {
		Recipe r1 = new Recipe();
		r1.setAmtChocolate(15);
		r1.setAmtCoffee(20);
		r1.setAmtMilk(15);
		r1.setAmtSugar(15);
		r1.setName("Coffee");
		r1.setPrice(50);
		assertFalse(inv.enoughIngredients(r1));
	}

	@Test
	public void testEnoughIngredientsReturnFalseForNotEnoughMilk() {
		Recipe r1 = new Recipe();
		r1.setAmtChocolate(15);
		r1.setAmtCoffee(15);
		r1.setAmtMilk(20);
		r1.setAmtSugar(15);
		r1.setName("Coffee");
		r1.setPrice(50);
		assertFalse(inv.enoughIngredients(r1));
	}

	@Test
	public void testEnoughIngredientsReturnFalseForNotEnoughSugar() {
		Recipe r1 = new Recipe();
		r1.setAmtChocolate(15);
		r1.setAmtCoffee(15);
		r1.setAmtMilk(15);
		r1.setAmtSugar(20);
		r1.setName("Coffee");
		r1.setPrice(50);
		assertFalse(inv.enoughIngredients(r1));
	}

	@Test
	public void testToString() {
		assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", inv.toString());
	}

}
