package Shops;

public class MallShop extends Shop implements ChainShop{

	public MallShop(int arrea,  String address) {
		super(arrea, 150, address);
		
	}

	@Override
	public void setArrea(int arr) {
		if(arr>=10 && arr<=100){
			this.arrea = arr;
		}
		else{
			this.arrea=50;
		}
	}
}
