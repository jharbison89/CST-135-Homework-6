
public class InventoryManagement {
	
	/*
	 * Created by James Harbison and Chase Hausman
	 * this class simulates a shopping cart for selecting items as well as manages inventory
	 */
	
	private Product[] shoppingCart;
	private int[] cartQuantity;
	private int cartSize = 0;
	
	public InventoryManagement() {
		shoppingCart = new Product[10];
		cartQuantity = new int[10];
	}
	
	
	// add an item to the cart and decrease item quantity
	public void selectItem(Product item) {
		// decrease item quantity by one
		item.decreaseQuantity();
		
		boolean notFound = true;
		// if an item in the shopping cart has the same name and price increment the quantity by one
		for(int i = 0; i < cartSize; i ++) {
			if(item.getName().equals(shoppingCart[i].getName()) && item.getPrice() == shoppingCart[i].getPrice()) {
				cartQuantity[i]++;
				i = cartSize + 1;
				notFound = false;
			}
		}
		
		// if no matching item is found add a new item to the shopping cart with quantity of one
		if(notFound) {
			shoppingCart[cartSize] = item;
			cartQuantity[cartSize] = 1;
			cartSize++;
		}
	}
	
	// remove an item from the cart and increase item quantitiy
	public void cancelItem(Product item) {
		
		item.increaseQuantity();
		
		// if an item in the shopping cart has the same name and price decrease the quantity by one
		for(int i = 0; i < cartSize; i ++) {
			if(item.getName() == shoppingCart[i].getName() && item.getPrice() == shoppingCart[i].getPrice()) {
			cartQuantity[i]--;
				i = cartSize + 1;
			}
		}
		
	}
	
	// remove all items from the cart and place back into the items inventory
	public void emptyCart() {
		for(int i = 0; i < cartSize; i ++) {
			shoppingCart[i].setCurrentQuantity(shoppingCart[i].getCurrentQuantity() + cartQuantity[i]);
			cartQuantity[i] = 0;
		}
	}
	
	// remove all items from cart and return total price for all items in the cart
	public double purchaseCart() {
		double price = 0;
		
		for(int i = 0; i < cartSize; i ++) {
			price = price + shoppingCart[1].getPrice() * cartQuantity[1];
			cartQuantity[i] = 0;
		}
		
		return price;
	}
	
	// return an tabular form of the shopping cart with quantity, name and price
	public String toString() {
		String string = "Your Shopping Cart\n";
		for(int i = 0; i < cartSize; i ++) {
			string = string + cartQuantity[i] + "\t" + shoppingCart[i].getName() + "\t$" + shoppingCart[i].getPrice() + "\n";
		}
		
		return string;
	}
}
