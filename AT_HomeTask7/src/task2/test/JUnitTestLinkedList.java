package task2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import task1.source.RLEDataCompression;
import task2.source.LinkedList;

public class JUnitTestLinkedList {
	private LinkedList myList = new LinkedList();

	@Test
	public void testAddInteger() {
		myList.add(1);
		assertEquals("1", myList.toString());
	}

	@Test
	public void testAddString() {
		myList.add(1);
		myList.add("Azaza");
		assertEquals("1 Azaza", myList.toString());
	}

	@Test
	public void testGet() {
		myList.add(1);
		myList.add("Azaza");
		assertEquals("1", myList.get(0) + "");
	}
	
	@Test
	public void testRemoveFirst() {
		myList.add(1);
		myList.add("Azaza");
		myList.remove(0);
		assertEquals("Azaza", myList.toString());
	}
	
	@Test
	public void testRemoveLast() {
		myList.add("Azaza");
		myList.remove(0);
		assertEquals("The list is empty", myList.toString());
	}
	
	@Test
	public void testGetFromEmptyList() {
		assertEquals(null, myList.get(0));
	}
	
	@Test
	public void testAddDouble() {
		myList.add(5.8);
		assertEquals("5.8", myList.toString());
	}

	@Test
	public void testRemoveNonexistent() {
		myList.add(5.8);
		myList.remove(10);
		assertEquals("5.8", myList.toString());
	}
}
