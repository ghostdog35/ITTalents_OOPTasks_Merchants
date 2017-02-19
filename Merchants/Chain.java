package Merchants;

import java.util.ArrayList;
import java.util.Random;

import Shops.ChainShop;
import Shops.Shop;


public class Chain extends Merchant{
	
	private final static int MAX_COUNT_SUPPL = 15;
	private final static int MAX_COUNT_SHOPS = 10;
	private ArrayList<Suplier> supliers;
	private ArrayList<ChainShop> shops;

	public Chain(String name, String address) {
		super(name, address, 3000);
		this.supliers= new ArrayList();
		this.shops = new ArrayList();
	}
	
	public boolean asignShop(Shop s){
		if(s!=null && s instanceof ChainShop && this.shops.size()<MAX_COUNT_SHOPS){
			this.shops.add((ChainShop) s);
			return true;
		}
		else{
			return false;
		}
	}
	public boolean addSupl(Suplier s){
		if(s!=null && this.supliers.size()<MAX_COUNT_SUPPL){
			return this.supliers.add(s);
		}
		else{
			return false;
		}
	}
	
	public void makeOrder(){
		double money=this.money*0.5/this.shops.size();
		
		for (ChainShop shop : shops) {
			double shopMoney=money;
			double order=0;
			Suplier supl = supliers.get(new Random().nextInt(supliers.size()));
			while(shopMoney>5){
				Product temp = supl.getRandomProduct();
				if(temp==null){
					System.out.println("No more products from this suplier");
					shop.showProducts();
					this.money-=order-(order*supl.getDiscount()/100);
					break;
				}
				if(temp.getPrice()<money){
					shop.addProduct(temp);
					shopMoney-=temp.getPrice();
					order+=temp.getPrice();
				}
			}
			this.money-=order-(order*supl.getDiscount()/100);
		}
		this.showInfo();
	}
	public void sellProducts(){
		for (ChainShop shop : shops) {
			this.money+=shop.sellProducts();
		}
		
	}
	
	public void showInfo(){
		System.out.println(this);
		for (ChainShop shop : shops) {
			shop.showProducts();
		}
		
	}
}