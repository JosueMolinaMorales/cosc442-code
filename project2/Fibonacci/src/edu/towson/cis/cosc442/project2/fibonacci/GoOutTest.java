package edu.towson.cis.cosc442.project2.fibonacci;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoOutTest {

	GoOut go;
	
	@Before
	public void setUp() throws Exception {
		go = new GoOut();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void BOR_t1() {
		assertTrue(go.goOut(0, 25, true, "Friday"));
	}

	@Test
	public void BOR_t2() {
		assertTrue(go.goOut(0, 10, true, "Thursday"));
	}
	
	@Test
	public void BOR_t3() {
		assertFalse(go.goOut(0, 10, true, "Friday"));
	}
	
	@Test
	public void BOR_t4() {
		assertTrue(go.goOut(0, 25, true, "Friday"));
	}
	
	@Test
	public void BOR_t5() {
		assertFalse(go.goOut(0, 5, false, "Thursday"));
	}
	
	@Test
	public void BRO_t1() {
		assertTrue(go.goOut(10, 25, true, ""));
	}
	
	@Test
	public void BRO_t2() {
		assertTrue(go.goOut(5, 20, true, ""));
	}
	
	@Test
	public void BRO_t3() {
		assertTrue(go.goOut(3, 25, true, ""));
	}
	
	@Test
	public void BRO_t4() {
		assertTrue(go.goOut(2, 20, true, ""));
	}
	
	@Test
	public void BRO_t5() {
		assertFalse(go.goOut(10, 5, true, ""));
	}
	
	@Test
	public void BRO_t6() {
		assertFalse(go.goOut(5, 5, false, ""));
	}
	
	@Test
	public void BRO_t7() {
		assertTrue(go.goOut(10, 25, false, ""));
	}
	
	@Test
	public void BRO_t8() {
		assertTrue(go.goOut(5, 20, false, ""));
	}
	
	
}
