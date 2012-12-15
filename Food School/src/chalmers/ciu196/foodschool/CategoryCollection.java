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
			Food auxfood=new Food();
			FoodCategory auxcat=new FoodCategory();
			ArrayList<Food> auxfoodlist=new ArrayList<Food>();
			ArrayList<Integer> auxids=new ArrayList<Integer>();
			
			for (int y=0;y<categorylist.size();y++){
				auxcat=categorylist.get(y);
				auxfoodlist=auxcat.getFoodsContained();

				//Convert the category image paths to image ids
				auxcat.setImageid(cont.getResources().getIdentifier(auxcat.getCatImagePath(), "drawable", "chalmers.ciu196.foodschool"));
				
				//Convert the category sound paths to sound ids
				auxcat.setSoundid(cont.getResources().getIdentifier(auxcat.getCatSoundPath(), "raw", "chalmers.ciu196.foodschool"));
				
				for (int i=0;i<auxfoodlist.size();i++){
					auxfood=auxfoodlist.get(i);
					
					
					//Convert the food reference to food id
					auxfood.setId(cont.getResources().getIdentifier(auxfood.getfoodRef(),"drawable", "chalmers.ciu196.foodschool"));
					
					//Convert the food image paths to image ids
					for (int x=0;x<auxfood.getImage_paths().size();i++){
						auxids.add(cont.getResources().getIdentifier(auxfood.getImage_paths().get(x), "drawable", "chalmers.ciu196.foodschool"));
					}
					
					//Coner the food sound paths to sound ids
					auxids.clear();
					for (int z=0;z<auxfood.getSound_paths().size();i++){
						auxids.add(cont.getResources().getIdentifier(auxfood.getSound_paths().get(z), "drawable", "chalmers.ciu196.foodschool"));
					}
					
					//Commit the changes
					auxfood.setImage_ids(auxids);
					

					
					//Commit the changes
					auxfood.setSound_ids(auxids);
					
					//Commit the changes
					auxfoodlist.set(i, auxfood);
				}
				
				//Commit the changes
				categorylist.set(y,auxcat);
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
