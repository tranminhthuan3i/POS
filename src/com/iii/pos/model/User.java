package com.iii.pos.model;

import java.text.DateFormat;
import java.util.Date;

//---------water-------------------//
public class User {

	private String username;
	private String password;
	private int sex;
	private int age;
	private String email;
	private String address;
	private String create_time;
	private String update_time;
	private int flag;

	public User() {
		username = "";
		password = "";
		sex = 1;
		age = 0;
		email = "";
		address = "";
		create_time = DateFormat.getDateTimeInstance().format(new Date());
		update_time = DateFormat.getDateTimeInstance().format(new Date());
		flag = 0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
