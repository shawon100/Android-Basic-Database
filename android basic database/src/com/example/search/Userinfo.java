package com.example.search;

public class Userinfo {

	 private int id;
	 private String name;
	 private String phone_number;
	 
	 
	 public Userinfo(int id, String name,String phone_number)
	 {
		 this.id=id;
		 this.name=name;
		 this.phone_number=phone_number;
	 }
	 
	 public Userinfo(String name,String phone_number)
	 {
	 
		 this.name=name;
		 this.phone_number=phone_number;
	 }
	 
	 public Userinfo()
	 {
		 
	 }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	 
	 
	 
	 

}
