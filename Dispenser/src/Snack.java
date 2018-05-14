
public abstract class Snack extends Product implements Comparable<Snack>{

	/* 
	 * Created by James Harbison and Chase Hausman
	 * This class extends the product class with items unique to snacks in a vending machine
	 */
	
	// initialize variables
	private String flavor;
	
	// no arg constructor
	protected Snack(){
		flavor = "Regular";
	}
	
	// overloaded constructor
	protected Snack(String name, double price, int maxQuantity, int currentQuantity, String flavor) {
		setName(name);
		setPrice(price);
		setMaxQuantity(maxQuantity);
		setCurrentQuantity(currentQuantity);
		this.flavor = flavor;
	}
	
	// constructor that copies an existing snack
	protected Snack(Snack snack) {
		setName(snack.getName());
		setPrice(snack.getPrice());
		setMaxQuantity(snack.getMaxQuantity());
		setCurrentQuantity(snack.getCurrentQuantity());
		flavor = snack.flavor;
	}
	
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	
	public String getFlavor() {
		return flavor;
	}
	
	@Override
	// compares items based on name alphabetically then by price if the same items are the same alphabetically
	// returns -1 if the item comes after in order, 1 if it comes before in order, and 0 if the items are the same
	public int compareTo(Snack snack) {
		int intCount = 0;
		
		// sets the number of characters to compare to the shortest name length
		if(getName().length() > snack.getName().length()) {
			intCount = snack.getName().length();
		}
		else{
			intCount = getName().length();
		}
		
		// compares each letter in order
		for(int i = 0; i < intCount; i ++) {		
			if(getName().toUpperCase().charAt(i) > snack.getName().toUpperCase().charAt(i)) {
				return 1;
			}
			else if(getName().toUpperCase().charAt(i) < snack.getName().toUpperCase().charAt(i)) {
				return -1;
			}
		}
		
		// if all the letters match determines if one name has more letters to compare then the other
		if(getName().length() < snack.getName().length()) {
			return -1;
		}
		else if(getName().length() > snack.getName().length()) {
			return 1;
		}
		// if the names have the same letters and are the same length compares prices
		else {
			if(getPrice() > snack.getPrice()) {
				return 1;
			}
			else if(getPrice() < snack.getPrice()) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Product Name\t" + getName() + "\nPrice\t\t" + getPrice() + "\nMax Quantity\t" + getMaxQuantity() + 
				"\nCurrent Quantity\t" + getCurrentQuantity() + "\nFlavor\t\t" + flavor;
	}
	
}
