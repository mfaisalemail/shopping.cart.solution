

import java.util.List;

public interface ShoppingCart {
	public void addProducts(String productData[]);
    public void addProduct(Product product);
    public void removeProduct(Product product);
    public List<Product> getProducts();
    public void removeAll();
}