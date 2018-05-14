
public class Main {
	/* 
	 * Created by James Harbison and Chase Hausman
	 * This class tests the purchase order class by creating a random array of dispensers and creating a purchase 
	 * order off of those randomly filled dispensers 
	 */
	
	public static void main(String[] args) {
		
		// initialize an array of Dispensers 
		Dispenser[] dispensers = new Dispenser[4];
		
		// fill each dispenser with a random filled dispenser of size 8 with the names Dispenser 0, Dispenser 1, .... 
		for(int i = 0; i < dispensers.length; i ++) {
			dispensers[i] = new Dispenser(8, "Dispenser " + i);
		}
		
		// initialize new restock
		Restock restock = new Restock();
		
		// print a purchase order of all dispensers
		System.out.println(restock.purchaseOrder(dispensers));
		
	}
}
