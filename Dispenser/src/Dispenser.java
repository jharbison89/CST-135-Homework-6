
public class Dispenser {
	
	/* 
	 * Created by James Harbison and Chase Hausman
	 * This class manages the products in a vending machine and is used to test the product class and its subclasses
	 */
	
	private Product[] products;
	private String name;
	
	
	// creates a default dispenser of size 8
	public Dispenser(){
		products = new Product[8];
		name = "default";
		createProducts();
	}
	
	// creates a dispenser of specified size
	public Dispenser(int size, String name) {
		products = new Product[size];
		this.name = name;
		createRandomDrinkProducts();
	}
	
	// creates default products evenly dispersed between Drinks, Gum, Candy, and Chips for a dispenser
	void createProducts() {
		for(int i = 0; i < products.length; i ++) {
			if(i % 4 == 0) {
				products[i] = new Drink(); 
			}
			else if(i % 4 == 1) {
				products[i] = new Chips();
			}
			else if(i % 4 == 2) {
				products[i] = new Gum();
			}
			else {
				products[i] = new Candy();
			}
		}
	}
	
	// creates drinks with "random" filled properties using the overloaded constructor
	void createRandomDrinkProducts() {
		for(int i = 0; i < products.length; i ++) {
			products[i] = new Drink("Drink" + i, 1.50, 10 , (int)(Math.random() * 10), 20); 
		}
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	// displays a list of each product using each classes toString method
	public void displayProducts() {
		
		for(int i = 0; i < products.length; i ++) {
			System.out.println("Product " + i + "\n" + products[i] + "\n");
		}
		
	}
	
	public int getSize() {
		return products.length;
	}
	
	public int getProductCurrentInventory(int i) {
		return products[i].getCurrentQuantity();
	}
	
	public String getProductName(int i) {
		return products[i].getName();
	}
	
	public double getProductPrice(int i) {
		return products[i].getPrice();
	}
	
	public int getProductMaxQuantity(int i) {
		return products[i].getMaxQuantity();
	}
	
	// returns a list of each product using each classes toString method
	public String toString() {
		String string = "";
		
		for(int i = 0; i < products.length; i ++) {
			string = string + "Product " + i + "\n" + products[i] + "\n\n";
		}
		
		return string;
	}
	

}
