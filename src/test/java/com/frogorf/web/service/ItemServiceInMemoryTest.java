/**
 * 
 */
package com.frogorf.web.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.frogorf.web.model.Item;

/** @author Tsurkin Alex
 * @version */
public class ItemServiceInMemoryTest {

	private ItemServiceInMemory service;
	private Long id;

	@Before
	public void init() {
		service = new ItemServiceInMemory();
		Item i = new Item();
		i.setName("initName");
		i.setNumber(1);
		id = service.add(i);
	}

	/** Test method for
	 * {@link com.frogorf.web.service.ItemServiceInMemory#get(java.lang.Long)}. */
	@Test
	public void testGet() {
		Item i = service.get(id);
		assertEquals("initName", i.getName());
	}

	/** Test method for
	 * {@link com.frogorf.web.service.ItemServiceInMemory#delete(java.lang.Long)}
	 * . */
	@Test
	public void testDelete() {
		service.delete(id);
		Item i = service.get(id);
		assertNull(i);
	}

	/** Test method for
	 * {@link com.frogorf.web.service.ItemServiceInMemory#update(java.lang.Long, com.frogorf.web.model.Item)}
	 * . */
	@Test
	public void testUpdate() {
		Item i = service.get(id);
		i.setName("newName");
		service.update(id, i);
		i = service.get(id);
		assertEquals("newName", i.getName());
	}

	/** Test method for
	 * {@link com.frogorf.web.service.ItemServiceInMemory#add(com.frogorf.web.model.Item)}
	 * . */
	@Test
	public void testAdd() {
		Item i = new Item();
		i.setName("postName");
		i.setNumber(1);
		Long id = service.add(i);
		Item postItem = service.get(id);
		assertEquals("postName", postItem.getName());

	}

}
