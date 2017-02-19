package Shops;

import Merchants.Product;

public interface ChainShop {

	void showProducts();

	void addProduct(Product temp);

	double sellProducts();

}
