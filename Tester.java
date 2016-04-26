
public class Tester {
	
	public static void main(String[] args) {

		String inputData []={"apple","apple","orange","apple","orange"};

		ShoppingCartImpl cart = new ShoppingCartImpl();

		cart.addProducts(inputData);
		
		showShoppingCartData(cart);

	}

	public static void showShoppingCartData(final ShoppingCartImpl cart) {
		System.out.println("\nSHopping Cart Products");
		for (Product product : cart.getProducts()) {
			System.out.println(product.toString());
		}
		System.out.println("Total Price: " + cart.getTotalPrice());
	}
}
