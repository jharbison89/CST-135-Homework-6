import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.stage.Stage; 
import javafx.scene.text.Text;

public class Main extends Application {
	/* 
	 * Created by James Harbison and Chase Hausman
	 * This class tests the purchase order class by creating a random array of dispensers and creating a purchase 
	 * order off of those randomly filled dispensers 
	 */

	private static String purchaseOrder;
	
	@Override
	public void start(Stage stage) {       
	    //Creating a Text object 
	    Text text = new Text();      
	    
	    //Setting the text to be added. 
	    text.setText(purchaseOrder); 
	     
	    //setting the position of the text 
	    text.setX(50); 
	    text.setY(50); 
	       
	    //Creating a Group object  
	    Group root = new Group(text);   
	             
	    //Creating a scene object 
	    Scene scene = new Scene(root, 600, 800);  
	    
	    //Setting title to the Stage 
	    stage.setTitle("Purchase Order"); 
	       
	    //Adding scene to the stage 
	    stage.setScene(scene); 
	       
	    //Displaying the contents of the stage 
	    stage.show(); 
	 }      

	public static void main(String[] args) {
		
		// initialize an array of Dispensers 
		Dispenser[] dispensers = new Dispenser[4];
		
		// fill each dispenser with a random filled dispenser of size 8 with the names Dispenser 0, Dispenser 1, .... 
		for(int i = 0; i < dispensers.length; i ++) {
			dispensers[i] = new Dispenser(8, "Dispenser " + i);
		}
		
		// initialize new restock
		Restock restock = new Restock();
		
		purchaseOrder = restock.purchaseOrder(dispensers);
		
		System.out.println(purchaseOrder);
		
		// print a purchase order of all dispensers
		launch(args);
		
	}
}
