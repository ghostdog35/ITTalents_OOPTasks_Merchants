package Shops;

public class Pavilion extends Shop implements SoleShop , ChainShop{

	public Pavilion(int arrea,  String address) {
		super(arrea, 50, address);
		
	}

	@Override
	public void setArrea(int arr) {
		if(arr>=4 && arr<=6){
			this.arrea = arr;
		}
		else{
			this.arrea=5;
		}
	}

}
