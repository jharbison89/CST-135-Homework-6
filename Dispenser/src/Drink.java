/**
 * Program: CST-135-Homework-2
 * File: Drink.java
 * Summary:
 * Author: Chase Hausman and James Harbison
 * Date: April 14, 2018
 */
public class Drink extends Product implements Comparable<Drink>{
    private int size; // Drink size in ounces

    public Drink() {
        this.size = 16;
    }

    public Drink(String name, double price, int maxQuantity, int currentQuantity, int size) {
    	setName(name);
		setPrice(price);
		setMaxQuantity(maxQuantity);
		setCurrentQuantity(currentQuantity);
		this.size = size;
    }

    public Drink(Drink initial) {
    	setName(initial.getName());
		setPrice(initial.getPrice());
		setMaxQuantity(initial.getMaxQuantity());
		setCurrentQuantity(initial.getCurrentQuantity());
        this.size = initial.size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    // compares items based on name alphabetically then by price if the same items are the same alphabetically
 	// returns -1 if the item comes after in order, 1 if it comes before in order, and 0 if the items are the same
	public int compareTo(Drink drink) {
		int intCount = 0;
		
		// sets the number of characters to compare to the shortest name length
		if(getName().length() > drink.getName().length()) {
			intCount = drink.getName().length();
		}
		else{
			intCount = getName().length();
		}
		
		// compares each letter in order
		for(int i = 0; i < intCount; i ++) {		
			if(getName().toUpperCase().charAt(i) > drink.getName().toUpperCase().charAt(i)) {
				return 1;
			}
			else if(getName().toUpperCase().charAt(i) < drink.getName().toUpperCase().charAt(i)) {
				return -1;
			}
		}
		
		// if all the letters match determines if one name has more letters to compare then the other
		if(getName().length() < drink.getName().length()) {
			return -1;
		}
		else if(getName().length() > drink.getName().length()) {
			return 1;
		}		
		// if the names have the same letters and are the same length compares prices
		else {
			if(getPrice() > drink.getPrice()) {
				return 1;
			}
			else if(getPrice() < drink.getPrice()) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
	
    @Override
    public String toString() {
        return super.toString() + "\nSize (ounces)\t\t" + this.getSize();
    }
}