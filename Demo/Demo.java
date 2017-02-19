package Demo;

import java.util.ArrayList;
import java.util.Random;

import Merchants.Ambulant;
import Merchants.Chain;
import Merchants.SoleTrader;
import Merchants.Suplier;
import Merchants.Suplier.Type;
import Shops.MallShop;
import Shops.Pavilion;
import Shops.Shop;
import Shops.Stall;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Suplier> supliers = new ArrayList();
		String[] supNames = {"Ivan", "Dragan", "Petkan", "Sasho", "Pesho", "Gosho", "Tosho"};
		String[] adresses = {"Lulin", "Mladost", "Nadejda", "Drujba", "Lozenec", "Strelbishte", "Geo Milev"};
		
		for (int i = 0; i < 15; i++) {
			if(new Random().nextBoolean()){
				supliers.add(new Suplier(Type.BIG, supNames[new Random().nextInt(supNames.length)], adresses[new Random().nextInt(adresses.length)]));
			}
			else{
				supliers.add(new Suplier(Type.SMALL, supNames[new Random().nextInt(supNames.length)], adresses[new Random().nextInt(adresses.length)]));
			}
		}
		ArrayList<Shop> shops = new ArrayList();
		for (int i = 0; i < 20; i++) {
			switch (new Random().nextInt(3)) {
			case 0:
				shops.add(new Stall(4, adresses[new Random().nextInt(adresses.length)]));
				break;
			case 1:
				shops.add(new Pavilion(4, adresses[new Random().nextInt(adresses.length)]));
				break;
			case 2:
				shops.add(new MallShop(4, adresses[new Random().nextInt(adresses.length)]));
				break;

			default:
				break;
			}
		}
		Ambulant pesho = new Ambulant("Pesho Dalaverata", "Lulin");
		SoleTrader pena = new SoleTrader("ET Pena Dobreva", "Mladost");
		Chain beneton = new Chain("Benetton LTd.", "Lozenec");
		while(true){
			if(pesho.addSupl(supliers.get(new Random().nextInt(supliers.size())))){
				break;
			}
		}
		int count=0;
		while(count<5){
			if(pena.addSupl(supliers.get(new Random().nextInt(supliers.size())))){
				count++;
			}
		}
		count=0;
		while(count<15){
			if(beneton.addSupl(supliers.get(new Random().nextInt(supliers.size())))){
				count++;
			}
		}
		while(true){
			if(pena.asignShop(shops.get(new Random().nextInt(shops.size())))){
				break;
			}
		}
		count=0;
		while(count<10){
			if(beneton.asignShop(shops.get(new Random().nextInt(shops.size())))){
				count++;
			}
		}
		
		pesho.makeOrder();
		pena.makeOrder();
		beneton.makeOrder();
		pesho.sellProducts();
		pena.sellProducts();
		beneton.sellProducts();
		pesho.showInfo();
		pena.showInfo();
		beneton.showInfo();

	}

}
