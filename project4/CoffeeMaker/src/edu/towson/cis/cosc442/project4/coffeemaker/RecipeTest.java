package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecipeTest {
	private Recipe r1;
	@Before
	public void setUp() throws Exception {
		r1 = new Recipe();
		r1.setAmtChocolate(15);
		r1.setAmtCoffee(15);
		r1.setAmtMilk(15);
		r1.setAmtSugar(15);
		r1.setName("Coffee");
		r1.setPrice(50);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAmtChocolate() {
		assertEquals(15, r1.getAmtChocolate());
	}

	@Test
	public void testSetAmtChocolate() {
		r1.setAmtChocolate(10);
		assertEquals(10, r1.getAmtChocolate());
	}

	@Test
	public void testSetAmtChocolateSetsToZero() {
		r1.setAmtChocolate(-10);
		assertEquals(0, r1.getAmtChocolate());
	}

	@Test
	public void testGetAmtCoffee() {
		assertEquals(15, r1.getAmtChocolate());
	}

	@Test
	public void testSetAmtCoffee() {
		r1.setAmtCoffee(10);
		assertEquals(10, r1.getAmtCoffee());
	}

	@Test
	public void testSetAmtCoffeeExlicitlyZero() {
		r1.setAmtCoffee(0);
		assertEquals(0, r1.getAmtCoffee());
	}

	@Test
	public void testSetAmtCoffeeSetsToZero() {
		r1.setAmtCoffee(-10);
		assertEquals(0, r1.getAmtCoffee());
	}

	@Test
	public void testGetAmtMilk() {
		assertEquals(15, r1.getAmtMilk());
	}

	@Test
	public void testSetAmtMilk() {
		r1.setAmtMilk(10);
		assertEquals(10, r1.getAmtMilk());
	}

	@Test
	public void testSetAmtMilkSetsToZero() {
		r1.setAmtMilk(-10);
		assertEquals(0, r1.getAmtMilk());
	}

	@Test
	public void testGetAmtSugar() {
		assertEquals(15, r1.getAmtSugar());
	}

	@Test
	public void testSetAmtSugar() {
		r1.setAmtSugar(10);
		assertEquals(10, r1.getAmtSugar());
	}

	@Test
	public void testSetAmtSugarSetsToZero() {
		r1.setAmtSugar(-10);
		assertEquals(0, r1.getAmtSugar());
	}

	@Test
	public void testGetName() {
		assertEquals("Coffee", r1.getName());
	}

	@Test
	public void testSetName() {
		r1.setName("Tea");
		assertEquals("Tea", r1.getName());
	}

	@Test
	public void testGetPrice() {
		assertEquals(50, r1.getPrice());
	}

	@Test
	public void testSetPrice() {
		r1.setPrice(10);
		assertEquals(10, r1.getPrice());
	}

	@Test
	public void testSetPriceSetToZero() {
		r1.setPrice(-10);
		assertEquals(0, r1.getPrice());
	}

	@Test
	public void testEqualsObject() {
		Recipe r2 = new Recipe();
		r2.setAmtChocolate(15);
		r2.setAmtCoffee(15);
		r2.setAmtMilk(15);
		r2.setAmtSugar(15);
		r2.setName("Coffee");
		r2.setPrice(50);
		assertTrue(r1.equals(r2));
	}

	@Test
	public void testEqualsObjectReturnsFalse() {
		Recipe r2 = new Recipe();
		r2.setAmtChocolate(15);
		r2.setAmtCoffee(15);
		r2.setAmtMilk(15);
		r2.setAmtSugar(15);
		r2.setName("Tea");
		r2.setPrice(50);
		assertFalse(r1.equals(r2));
	}

	@Test
	public void testEqualsObjectReturnsFalseForNullName() {
		Recipe r2 = new Recipe();
		r2.setAmtChocolate(15);
		r2.setAmtCoffee(15);
		r2.setAmtMilk(15);
		r2.setAmtSugar(15);
		r2.setName("Coffee");
		r2.setPrice(50);
		r1.setName(null);
		assertFalse(r1.equals(r2));
	}

	@Test
	public void testToString() {
		String expected = "Coffee";
		assertEquals(expected, r1.toString());
	}

	@Test
	public void testEqualsObjectReturnFalseForNull() {
		assertFalse(r1.equals(null));
	}

}
