package com.iii.pos.item;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;

//----model item object----//
public class Items_Detail{

	String _id;
	String name;
	int status;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
