

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl implements ShoppingCart{

	private List<Product> productsList;

	public ShoppingCartImpl() {
		productsList = new ArrayList<Product>();
	}
	
	public void addProducts(String productData[]) {
		
		for( String data:productData)
			 addProduct(new Product(data));		
	}

	@Override
	public void addProduct(Product product) {
		boolean isNewItem = true;
		Product addedItem = product;
		for (Product scItem : productsList) {
			if (product.getName().compareToIgnoreCase(scItem.getName()) == 0) {
				isNewItem = false;
				scItem.setQuantity(scItem.getQuantity() + product.getQuantity());
				addedItem = scItem;
			}
		}

		if (isNewItem) {
			productsList.add(product);
		}
		applyDiscountOffer(addedItem);

	}

	@Override
	public void removeProduct(Product product) {
		productsList.remove(product);
		
	}

	@Override
	public List<Product> getProducts() {
		return productsList;
	}

	public double getTotalPrice() {
		double totalPrice = 0;
		for (int i = 0; i < productsList.size(); i++) {
			Product item = productsList.get(i);
			totalPrice = totalPrice + item.getPrice();
		}
		return totalPrice;
	}

	@Override
	public void removeAll() {
		productsList.clear();

	}

	private void applyDiscountOffer(Product item) {			
		int qty = item.getQuantity();
		double unitPrice = item.getUnitPrice();
		int freeQty = 0;
		switch (item.getName()) {
		case "apple":
			freeQty = (int) qty / 2; // BUY ONE GET ONE FREE
			break;
		case "orange":
			freeQty = (int) qty / 3; // BUY THREE GET ONE FREE
			break;
		default:
			break;
		}

		double discount = freeQty * unitPrice;
		item.setDiscount(discount);
	}

}
