package com.iii.pos.model;

//-----invoice model-------//
public class Invoice {

	private int inv_id;
	private String name_item;
	private String unit_item;
	private int amount_item;
	private float cost_item;
	private String notes;

	public int getInv_id() {
		return inv_id;
	}

	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}

	public String getName_item() {
		return name_item;
	}

	public void setName_item(String name_item) {
		this.name_item = name_item;
	}

	public String getUnit_item() {
		return unit_item;
	}

	public void setUnit_item(String unit_item) {
		this.unit_item = unit_item;
	}

	public int getAmount_item() {
		return amount_item;
	}

	public void setAmount_item(int amount_item) {
		this.amount_item = amount_item;
	}

	
	public float getCost_item() {
		return cost_item;
	}

	public void setCost_item(float cost_item) {
		this.cost_item = cost_item;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
