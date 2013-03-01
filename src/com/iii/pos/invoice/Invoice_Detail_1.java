package com.iii.pos.invoice;

public class Invoice_Detail_1 {
	private int inv_id;
	private float total;
	private String inv_code;
	private float vat;
	private float commision;
	private String inv_starttime;
	private String inv_endtime;
	private int user_id;
	private int client_id;
	private int item_id;
	private int flag;

	private String name_item;
	private int unit_item;
	private float amount_item;
	private float cost_item;
	private String description;

	public int getInv_id() {
		return inv_id;
	}

	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getInv_code() {
		return inv_code;
	}

	public void setInv_code(String inv_code) {
		this.inv_code = inv_code;
	}

	public float getVat() {
		return vat;
	}

	public void setVat(float vat) {
		this.vat = vat;
	}

	public float getCommision() {
		return commision;
	}

	public void setCommision(float commision) {
		this.commision = commision;
	}

	public String getInv_starttime() {
		return inv_starttime;
	}

	public void setInv_starttime(String inv_starttime) {
		this.inv_starttime = inv_starttime;
	}

	public String getInv_endtime() {
		return inv_endtime;
	}

	public void setInv_endtime(String inv_endtime) {
		this.inv_endtime = inv_endtime;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getName_item() {
		return name_item;
	}

	public void setName_item(String name_item) {
		this.name_item = name_item;
	}

	public int getUnit_item() {
		return unit_item;
	}

	public void setUnit_item(int unit_item) {
		this.unit_item = unit_item;
	}

	public float getAmount_item() {
		return amount_item;
	}

	public void setAmount_item(float amount_item) {
		this.amount_item = amount_item;
	}

	public float getCost_item() {
		return cost_item;
	}

	public void setCost_item(float cost_item) {
		this.cost_item = cost_item;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
