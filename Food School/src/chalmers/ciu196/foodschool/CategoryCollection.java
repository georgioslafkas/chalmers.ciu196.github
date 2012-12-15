package chalmers.ciu196.foodschool;

import java.util.ArrayList;

import android.content.Context;


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
	
		public void setIds(Context cont){
			Food aux=new Food();
			FoodCategory aux2=new FoodCategory();
			ArrayList<Food> aux3=new ArrayList<Food>();
			for (int y=0;y<categorylist.size();y++){
				aux2=categorylist.get(y);
				aux3=aux2.getFoodsContained();
				for (int i=0;i<aux3.size();i++){
					aux=aux3.get(i);
					aux.setId(cont.getResources().getIdentifier(aux.getfoodRef(),"drawable", "chalmers.ciu196.foodschool"));
					aux3.set(i, aux);
				}
				categorylist.set(y,aux2);
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
