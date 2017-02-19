package Merchants;

import java.util.ArrayList;
import java.util.Random;

import Merchants.Suplier.Type;
import Shops.Shop;
import Shops.SoleShop;

public class SoleTrader extends Merchant{
	
	private final static int MAX_COUNT_SUPPL = 5;
	private ArrayList<Suplier> supliers;
	private SoleShop shop;

	public SoleTrader(String name, String address) {
		super(name, address, 500);
		this.supliers= new ArrayList();
	}
	
	public boolean asignShop(Shop s){
		if(s!=null && s instanceof SoleShop && this.shop==null){
			this.shop = (SoleShop) s;
			return true;
		}
		else{
			return false;
		}
	}
	public boolean addSupl(Suplier s){
		if(s!=null && s.getType()==Type.SMALL && this.supliers.size()<MAX_COUNT_SUPPL){
			return this.supliers.add(s);
		}
		else{
			return false;
		}
	}
	public void makeOrder(){
		double money=(double) (this.money*0.5);
		double order=0;
		Suplier supl = supliers.get(new Random().nextInt(supliers.size()));
		
		while(money>5){
			Product temp = supl.getRandomProduct();
			if(temp==null){
				System.out.println("No more products from this suplier");
				this.shop.showProducts();
				this.money-=order;
				return;
			}
			if(temp.getPrice()<money){
				this.shop.addProduct(temp);
				money-=temp.getPrice();
				order+=temp.getPrice();
			}
		}
		this.money-=order;
		this.showInfo();
		return;
	}
	
	public void sellProducts(){
	
		this.money+=this.shop.sellProducts();
	}
	
	public void showInfo(){
		System.out.println(this);
		this.shop.showProducts();
	}
}
