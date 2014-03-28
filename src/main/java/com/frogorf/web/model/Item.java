/**
 * 
 */
package com.frogorf.web.model;

/** @author Tsurkin Alex
 * @version */
public class Item {

	private Long id;
	private String name;
	private Integer number;

	/** @return the id */
	public Long getId() {
		return id;
	}

	/** @param id the id to set */
	public void setId(Long id) {
		this.id = id;
	}

	/** @return the name */
	public String getName() {
		return name;
	}

	/** @param name the name to set */
	public void setName(String name) {
		this.name = name;
	}

	/** @return the number */
	public Integer getNumber() {
		return number;
	}

	/** @param number the number to set */
	public void setNumber(Integer number) {
		this.number = number;
	}

	public Item() {

	}

	/** @param name
	 * @param number */
	public Item(String name, Integer number) {
		super();
		this.name = name;
		this.number = number;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return String.format("Item [id=%s, name=%s, number=%s]", id, name, number);
	}
}
