

import java.text.DecimalFormat;

public class Product {
	
	String name;
	int quantity;
	double unitPrice;
	double discount;

	public Product(String name) {
		this.name = name;
		this.quantity = 1;
		if("apple".compareToIgnoreCase(name)==0)
			this.unitPrice = 0.60;
		else if("orange".compareToIgnoreCase(name)==0)
			this.unitPrice = 0.25;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int qty) {
		quantity = qty;
	}

	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setDiscount(double discount)
	{
		this.discount = discount;
	}

	public double getPrice() {
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.valueOf(df.format(unitPrice * quantity-discount));
	}

	public String toString() {
		return "["+name + ": quantity=" + quantity + " Price=" + getPrice()
				+ " unitPrice=" + unitPrice
				+ " discount=" + discount+"]";
	}
}
