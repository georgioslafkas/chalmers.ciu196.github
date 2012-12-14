package chalmers.ciu196.foodschool;

import java.util.ArrayList;


public class CategoryCollection extends Object{ 
	
	// PROBABLY NEEDS DISCUSSION WITH THE GROUP
	
		private ArrayList<FoodCategory> categorylist = new ArrayList<FoodCategory>();
		
		// Getters and Setters of the parameters above
		
		// id
		public ArrayList<FoodCategory> getList() {
			return categorylist;
		}
		public void setList(ArrayList<FoodCategory> inputlist) {
			categorylist.clear();
			for (int i=0;i<inputlist.size();i++){
				this.categorylist.add(inputlist.get(i));
			}
		}
	
		
		// Constructor
		
		public CategoryCollection( ArrayList<FoodCategory> inputlist){			
			for (int i=0;i<inputlist.size();i++){
				this.categorylist.add(inputlist.get(i));
			}
		}
		
		public CategoryCollection(){			

		}
		
		
} // End of class
