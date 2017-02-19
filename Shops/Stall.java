package Shops;

public class Stall extends Shop implements SoleShop{

	public Stall(int arrea,  String address) {
		super(arrea, 50, address);
		
	}

	@Override
	public void setArrea(int arr) {
		if(arr>=2 && arr<=10){
			this.arrea = arr;
		}
		else{
			this.arrea=50;
		}
	}
}