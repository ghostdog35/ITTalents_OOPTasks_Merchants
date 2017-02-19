package Shops;


import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import Merchants.Product;


public abstract class Shop {
	
	protected int arrea;
	private int tax;
	private String address;
	private String workingTime;
	private ArrayList<Product> products;
	private ArrayList<Product> soldProducts; 
	private double oborot;
	
	public Shop(int arrea, int tax, String address) {
		this.setArrea(arrea);
		this.tax = tax;
		this.address = address;
		this.workingTime = "09.00 - 18.00";
		this.products= new ArrayList();
		this.soldProducts = new ArrayList();
		this.oborot=0;
	}
	
	public abstract void setArrea(int arr);
	
	public Product getRandomProduct(){
		if(this.products.size()>0){
			return this.products.get(new Random().nextInt(this.products.size()));
		}
		return null;
	}
	
	public boolean removeProduct(Product p){
		return this.products.remove(p);
	}
	
	public void addProduct(Product p){
		if(p!=null){
			this.products.add(p);
		}
	}
	
	public double sellProducts(){
		int count = new Random().nextInt(this.products.size());
		int money=0;
		for (int i = 0; i < count; i++) {
			Product temp = this.products.get(new Random().nextInt(this.products.size()));
			money+=temp.getPrice();
			this.soldProducts.add(temp);
			this.products.remove(temp);
		}
		this.oborot=money*0.3;
		return money;
	}
	
	
	
	public void showProducts(){
		TreeSet<Product> sorted = new TreeSet();
		sorted.addAll(this.products);
		System.out.println(this.address);
		System.out.println(sorted);
		System.out.println("Profit - "+this.oborot);
	}
	
	
	
	

}
