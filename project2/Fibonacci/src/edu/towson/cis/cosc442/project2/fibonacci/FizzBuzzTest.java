package edu.towson.cis.cosc442.project2.fibonacci;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {
	public FizzBuzz fb;
	
	@Before
	public void setUp() throws Exception {
		fb = new FizzBuzz();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFizzBuzzReturnsEmptyString() {
		assertEquals("", fb.fizzBuzz(0));
	}
	
	@Test
	public void testFizzBuzzReturnsLongStringWhenNis35() {
		assertEquals(" fizz buzz fizz buzz fizz fizz buzz fizz buzz fizz fizzbuzz", fb.fizzBuzz(35));
	}
	
	@Test
	public void testFizzBuzzReturnsJustFizz() {
		assertEquals(" fizz", fb.fizzBuzz(5));
	}
	
	@Test
	public void testFizzBuzzReturnsFizzBuzz() {
		assertEquals(" fizz buzz", fb.fizzBuzz(7));
	}

}
