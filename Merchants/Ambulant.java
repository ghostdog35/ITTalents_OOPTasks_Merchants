package Merchants;

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import Merchants.Suplier.Type;

public class Ambulant extends Merchant{
	
	private ArrayList<Product> products;
	private Suplier suplier;
	private ArrayList<Product> soldProducts; 
	private double oborot;

	public Ambulant(String name, String address) {
		super(name, address, 100);
		this.products= new ArrayList();
		this.soldProducts = new ArrayList();
		this.oborot=0;
	}
	
	public boolean addSupl(Suplier s){
		if(s!=null && s.getType()==Type.SMALL && this.suplier==null){
			this.suplier=s;
			return true;
		}
		else{
			return false;
		}
	}
	
	public void makeOrder(){
		double money=this.money*0.5;
		double order=0;
		while(money>5){
			Product temp = this.suplier.getRandomProduct();
			if(temp==null){
				System.out.println("No more products from this suplier");
				this.showProducts();
				this.money-=order;
				return;
			}
			if(temp.getPrice()<money){
				this.products.add(temp);
				money-=temp.getPrice();
				order+=temp.getPrice();
			}
		}
		this.money-=order;
		this.showInfo();
		return;
	}
	
	public void sellProducts(){
		int count = new Random().nextInt(this.products.size());
		int money=0;
		for (int i = 0; i < count; i++) {
			Product temp = this.products.get(new Random().nextInt(this.products.size()));
			money+=temp.getPrice();
			this.soldProducts.add(temp);
			this.products.remove(temp);
		}
		this.oborot=money*0.3;
		this.money+=money;
	}
	
	public void showProducts(){
		TreeSet<Product> sorted = new TreeSet();
		sorted.addAll(this.products);
		System.out.println(sorted);
	}
	public void showInfo(){
		System.out.println(this);
		this.showProducts();
		System.out.println("Profit - "+this.oborot);
	}

}
