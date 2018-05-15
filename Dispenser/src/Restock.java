
public class Restock{
	
	private final int LOW_INVENTORY = 3;
	private double totalCost;
		
	public Restock() {
		totalCost = 0;
		
	}
	

	
	
	
	// returns restocking list with a dispenser input
	public String purchaseOrder(Dispenser input) {
		String output = "\nDispenser - " + input.getName() +"\n";
		double totalPrice = 0;
		
		for(int i = 0; i < input.getSize(); i ++) {
			if(input.getProductCurrentInventory(i) <= LOW_INVENTORY) {
				
				int quantityNeeded = input.getProductMaxQuantity(i) - input.getProductCurrentInventory(i);
				totalPrice = totalPrice + (quantityNeeded * input.getProductPrice(i));
				
				output = output + input.getProductName(i) + "\t" + quantityNeeded + " needed\n";
			}
		}
		
		output = output + "Total Cost - $" + String.format("%.2f", totalPrice)+ "\n";
		totalCost = totalCost + totalPrice;
		
		return output;
	}
	
	// returns restocking list with a product array input
	public String purchaseOrder(Product[] input) {
		String output = "Items for re-order:\n";
		
		for(int i = 0; i < input.length; i ++) {
			if(input[i].getCurrentQuantity() <= LOW_INVENTORY) {
				
				int quantityNeeded = input[i].getMaxQuantity() - input[i].getCurrentQuantity();
				double totalPrice = quantityNeeded * input[i].getPrice();
				
				output = output + input[i].getName() + "\t" + input[i].getPrice() + "\t" +
						quantityNeeded + "\t Total Cost - $" + totalPrice + "\n";
			}
		}
		
		return output;
	}
	
	// returns restocking list for a list of multiple dispensers
	public String purchaseOrder(Dispenser[] input) {
		String output = "***Purchase Order***\n";
		// reset totalCost
		totalCost = 0;
		
		
		for(int i = 0; i < input.length; i ++) {
			output = output + purchaseOrder(input[i]);
		}
		
		output = output + "\n\n" + "Total Cost of all items - $" + String.format("%.2f", totalCost);
		
		return output;
	}
	
}
