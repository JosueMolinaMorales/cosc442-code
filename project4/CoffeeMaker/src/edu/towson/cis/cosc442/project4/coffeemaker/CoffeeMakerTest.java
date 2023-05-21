package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class CoffeeMakerTest {
	private CoffeeMaker cm;
	private Recipe r1;
	
	@Before
	public void setUp() {
		cm = new CoffeeMaker();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(4);
	}
	
	@After
	public void tearDown() {
		
	}

	@Test
	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}

	/**
	 * Test to see if the recipe is not added because it already exists
	 */
	@Test
	public void testAddRecipe2() {
		assertTrue(cm.addRecipe(r1));
		assertFalse(cm.addRecipe(r1));
	}

	/**
	 * Test to see if the recipe is not added because there are no empty spots
	 */
	@Test
	public void testAddRecipe3() {
		Recipe r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setPrice(50);
		r2.setAmtCoffee(6);
		r2.setAmtMilk(1);
		r2.setAmtSugar(1);
		r2.setAmtChocolate(0);
		
		Recipe r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setPrice(50);
		r3.setAmtCoffee(6);
		r3.setAmtMilk(1);
		r3.setAmtSugar(1);
		r3.setAmtChocolate(0);
		
		Recipe r4 = new Recipe();
		r4.setName("Coffee4");
		r4.setPrice(50);
		r4.setAmtCoffee(6);
		r4.setAmtMilk(1);
		r4.setAmtSugar(1);
		r4.setAmtChocolate(0);
		
		Recipe r5 = new Recipe();
		r5.setName("Coffee5");
		r5.setPrice(50);
		r5.setAmtCoffee(6);
		r5.setAmtMilk(1);
		r5.setAmtSugar(1);
		r5.setAmtChocolate(0);
		
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		assertFalse(cm.addRecipe(r5));
	}

	@Test
	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}

	/**
	 * Test to see if the recipe is not deleted because it does not exist
	 */
	@Test
	public void testDeleteRecipe2() {
		assertFalse(cm.deleteRecipe(r1));
	}

	@Test
	public void testDeleteRecipe3() {
		assertFalse(cm.deleteRecipe(null));
	}

	@Test
	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}

	/**
	 * Test to see if the recipe is not edited because it does not exist
	 */
	@Test
	public void testEditRecipe2() {
		Recipe newRecipe = new Recipe();
		assertFalse(cm.editRecipe(r1, newRecipe));
	}

	/**
	 * Test to see if the recipe is not edited because you cannot edit the name of a recipe
	 */
	@Test
	public void testEditRecipe3() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe.setName("NotCoffee");
		assertFalse(cm.editRecipe(r1, newRecipe));
	}

	/**
	 * Test to see if the inventory is updated
	 */
	@Test
	public void testAddInventory1() {
		assertTrue(cm.addInventory(10, 10, 10, 10));
		Inventory i = cm.checkInventory();
		assertTrue(i.getCoffee() == 25);
		assertTrue(i.getMilk() == 25);
		assertTrue(i.getSugar() == 25);
		assertTrue(i.getChocolate() == 25);
	}

	@Test
	public void testAddInventory2() {
		assertFalse(cm.addInventory(-1, 0, 0, 0));
		Inventory i = cm.checkInventory();
		assertTrue(i.getCoffee() == 15);
		assertTrue(i.getMilk() == 15);
		assertTrue(i.getSugar() == 15);
		assertTrue(i.getChocolate() == 15);
	}

	@Test
	public void testAddInventory3() {
		assertFalse(cm.addInventory(0, -1, 0, 0));
		Inventory i = cm.checkInventory();
		assertTrue(i.getCoffee() == 15);
		assertTrue(i.getMilk() == 15);
		assertTrue(i.getSugar() == 15);
		assertTrue(i.getChocolate() == 15);
	}

	@Test
	public void testAddInventory4() {
		assertFalse(cm.addInventory(0, 0, -1, 0));
		Inventory i = cm.checkInventory();
		assertTrue(i.getCoffee() == 15);
		assertTrue(i.getMilk() == 15);
		assertTrue(i.getSugar() == 15);
		assertTrue(i.getChocolate() == 15);
	}

	@Test
	public void testAddInventory5() {
		assertFalse(cm.addInventory(0, 0, 0, -1));
		Inventory i = cm.checkInventory();
		assertTrue(i.getCoffee() == 15);
		assertTrue(i.getMilk() == 15);
		assertTrue(i.getSugar() == 15);
		assertTrue(i.getChocolate() == 15);
	}

	@Test
	public void testCheckInventory1() {
		Inventory i = cm.checkInventory();
		assertTrue(i.getCoffee() == 15);
		assertTrue(i.getMilk() == 15);
		assertTrue(i.getSugar() == 15);
		assertTrue(i.getChocolate() == 15);
	}

	@Test
	public void testCheckInventory2() {
		cm.addRecipe(r1);
		cm.makeCoffee(r1, 100);
		Inventory i = cm.checkInventory();
		assertTrue(i.getCoffee() == (15 - r1.getAmtCoffee()));
		assertTrue(i.getMilk() == (15 - r1.getAmtMilk()));
		assertTrue(i.getSugar() == (15 - r1.getAmtSugar()));
		assertTrue(i.getChocolate() == (15 - r1.getAmtChocolate()));
	}

	@Test
	public void testMakePurchase1() {
		cm.addRecipe(r1);
		assertEquals(0, cm.makeCoffee(r1, r1.getPrice()));
		// Check that the inventory is updated
		Inventory i = cm.checkInventory();
		assertTrue(i.getCoffee() == (15 - r1.getAmtCoffee()));
		assertTrue(i.getMilk() == (15 - r1.getAmtMilk()));
		assertTrue(i.getSugar() == (15 - r1.getAmtSugar()));
		assertTrue(i.getChocolate() == (15 - r1.getAmtChocolate()));
	}

	@Test
	public void testMakePurchase2() {
		cm.addRecipe(r1);
		assertEquals(r1.getPrice() - 10, cm.makeCoffee(r1, r1.getPrice() - 10));
	}

	@Test
	public void testMakePurchase3() {
		cm.addRecipe(r1);
		assertEquals(10, cm.makeCoffee(r1, r1.getPrice() + 10));
	}

	@Test
	public void testMakePurchase5() {
		Recipe r = new Recipe();
		r.setName("Coffee");
		r.setPrice(50);
		r.setAmtCoffee(20);
		r.setAmtMilk(20);
		r.setAmtSugar(20);
		r.setAmtChocolate(20);
		cm.addRecipe(r);
		assertEquals(50, cm.makeCoffee(r, 50));
	}

	@Test
	public void testGetReceipe() {
		cm.addRecipe(r1);
		Recipe[] rs = cm.getRecipes();
		boolean found = false;
		for (int i = 0; i < rs.length; i++) {
			if (rs[i].equals(r1)) {
				found = true;
			}
		}
		assertTrue(found);
	}

	@Test
	public void testGetRecipeByName() {
		cm.addRecipe(r1);
		Recipe r = cm.getRecipeForName("Coffee");
		assertTrue(r.equals(r1));
	}

	@Test
	public void testGetRecipeByNameReturnsEmptyRecipe() {
		cm.addRecipe(r1);
		Recipe r = cm.getRecipeForName("NotCoffee");
		assertTrue(r.getName() == null);
	}
}