package chalmers.ciu196.foodschool;

import java.util.ArrayList;


public class FoodCollection extends Object{ 
	
	// PROBABLY NEEDS DISCUSSION WITH THE GROUP
	
		private ArrayList<Food> foodlist = new ArrayList<Food>();
		
		// Getters and Setters of the parameters above
		
		// id
		public ArrayList<Food> getList() {
			return foodlist;
		}
		public void setList(ArrayList<Food> inputlist) {
			foodlist.clear();
			for (int i=0;i<inputlist.size();i++){
				this.foodlist.add(inputlist.get(i));
			}
		}
	
		
		// Constructor
		
		public FoodCollection( ArrayList<Food> inputlist){			
			for (int i=0;i<inputlist.size();i++){
				this.foodlist.add(inputlist.get(i));
			}
		}
		
		public FoodCollection(){			

		}
		
		
} // End of class
