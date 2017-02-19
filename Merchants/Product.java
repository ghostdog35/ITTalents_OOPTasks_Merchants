package Merchants;

public class Product implements Comparable<Product> {
	
	
	private String name;
	private int price;
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	
	


	@Override
	public String toString() {
		return name + " - " + price + " lv.";
	}


	@Override
	public int compareTo(Product o) {
		if(this.price==o.price){
			return 1;
		}
		return this.price-o.price;
	}
	
	

}
