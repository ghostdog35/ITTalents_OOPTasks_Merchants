package Merchants;

import java.util.ArrayList;



public abstract class Merchant {
	
	private String name;
	private String address;
	protected double money;
	
	public Merchant(String name, String address, int money) {
		this.name = name;
		this.address = address;
		this.money = money;
	}

	@Override
	public String toString() {
		return "Merchant " + name + " - " + address + " money - " + money;
	}
	
	public void showInfo(){
		System.out.println(this);
	}
	
	
	
	
	
	
	
	

}
