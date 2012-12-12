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
		public void setList(ArrayList<Food> test) {
			foodlist.clear();
			for (int i=0;i<test.size();i++){
				this.foodlist.add(test.get(i));
			}
		}
	
		
		// Constructor
		
		public FoodCollection( ArrayList<Food> test){			
			for (int i=0;i<test.size();i++){
				this.foodlist.add(test.get(i));
			}
		}
		
		public FoodCollection(){			

		}
		
		
} // End of class
