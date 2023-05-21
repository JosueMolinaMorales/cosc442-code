package edu.towson.cis.cosc442.project2.fibonacci;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CountSevenTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountSevenOne() {
		int expected = 2;
		int result = CountSeven.countSeven(new int[] { 0, 1, 7, 7, 2 });
		assertEquals(expected, result);
	}
	
	@Test
	public void testCountSevenTwo() {
		int expected = 2;
		int result = CountSeven.countSeven(new int[] { 4, 2, 3, 7, 7 });
		assertEquals(expected, result);
	}
	
	@Test
	public void testCountSevenReturnsZero() {
		int expected = 0;
		int result = CountSeven.countSeven(new int[] { 4, 32, 5, 1, 6, 5 });
		assertEquals(expected, result);
	}

}
