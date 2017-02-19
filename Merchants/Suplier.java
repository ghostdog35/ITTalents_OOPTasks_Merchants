package Merchants;

import java.util.ArrayList;
import java.util.Random;

public class Suplier {
	
	public enum Type{
		BIG, SMALL
	}
	private Type type;
	private String name;
	private String address;
	private String workingTime;
	private ArrayList<Product> products;
	public Suplier(Type type, String name, String address) {
		this.type = type;
		this.name = name;
		this.address = address;
		this.workingTime="09.00 - 18.00";
		this.products= new ArrayList<Product>();
		String[] productNames = {"bluza", "gashti", "teniska","hlqb","kniga","qke","pantalon","maratonki","chasovnik"};
		for (int i = 0; i < 50; i++) {
			this.products.add(new Product(productNames[new Random().nextInt(productNames.length)], new Random().nextInt(11)+5));
		}
	}
	
	public Product getRandomProduct(){
		if(this.products.size()>0){
			return this.products.get(new Random().nextInt(this.products.size()));
		}
		return null;
	}
	
	public int getDiscount(){
		if(this.type==Type.BIG){
			return 15;
		}
		return 0;
	}


	public Type getType() {
		return type;
	}
	
	
	
	
	

}
