/**
 * 
 */
package com.frogorf.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.frogorf.web.model.Item;
import com.frogorf.web.service.ItemServiceInMemory;

/** @author Tsurkin Alex
 * @version */
public class ItemRESTControllerTest {

	private String uri = "http://localhost:8080/web/item/";
	private RestTemplate template = new RestTemplate();
	private URI l;

	@Before
	public void init() {
		Item i = new Item();
		i.setName("initName");
		i.setNumber(1);
		l = template.postForLocation(uri, i);
	}

	/** Test method for
	 * {@link com.frogorf.web.controller.ItemRESTController#get(java.lang.Long)}
	 * . */
	@Test
	public void testGet() {
		Item i = template.getForObject(l, Item.class);
		assertEquals("initName", i.getName());
	}

	/** Test method for
	 * {@link com.frogorf.web.controller.ItemRESTController#delete(java.lang.Long)}
	 * . */
	@Test
	public void testDelete() {
		template.delete(l);

	}

	/** Test method for
	 * {@link com.frogorf.web.controller.ItemRESTController#update(java.lang.Long, com.frogorf.web.model.Item)}
	 * . */
	@Test
	public void testUpdate() {
		Item i = template.getForObject(l, Item.class);
		i.setName("newName");
		template.put(l, i);
		i = template.getForObject(l, Item.class);
		assertEquals("newName", i.getName());
	}

	/** Test method for
	 * {@link com.frogorf.web.controller.ItemRESTController#add(com.frogorf.web.model.Item, javax.servlet.http.HttpServletRequest)}
	 * . */
	@Test
	public void testAdd() {
		Item i = new Item();
		i.setName("postName");
		i.setNumber(1);
		l = template.postForLocation(uri, i);
		i = template.getForObject(l, Item.class);
		assertEquals("postName", i.getName());
	}

}
