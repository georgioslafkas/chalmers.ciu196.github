package chalmers.ciu196.foodschool;

import java.util.ArrayList;

import android.content.Context;


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
		public void setIds(Context cont){
			Food aux=new Food();
			for (int i=0;i<foodlist.size();i++){
				aux=foodlist.get(i);
				aux.setId(cont.getResources().getIdentifier(aux.getfoodRef(),"drawable", "chalmers.ciu196.foodschool"));
				foodlist.set(i, aux);
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
