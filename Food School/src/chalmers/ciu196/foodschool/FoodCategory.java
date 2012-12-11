package chalmers.ciu196.foodschool;

import java.util.ArrayList;



public class FoodCategory extends Object{ 
	
	// PROBABLY NEEDS DISCUSSION WITH THE GROUP
	
	private String name, // Name of the category
	   description, // Description of the category
	   imagePath, // Path where the category icon is stored
	   soundPath; // Path where the sound file of the category is stored
	
	private int catId; // Category id

	private ArrayList<Food> foodsContained = new ArrayList<Food>();

	// Constructor
	public FoodCategory(String catName, String catDesc, String cImagePath, String cSoundPath, int cId){
			
		this.setCatName(catName);
		this.setCatDescription(catDesc);
		this.setCatImagePath(cImagePath);		
		this.setCatSoundPath(cSoundPath);
		this.setCatId(cId);
	}
		
	// Default constructor
	public FoodCategory(){
			
		this.setCatName(null);
		this.setCatDescription(null);
		this.setCatImagePath(null);
		this.setCatSoundPath(null);
		this.setCatId(0);
	}	
		
	// Getters and Setters	
		
	// id 
	
	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}
	
	// name
	public String getCatName() {
		return name;
	}

	public void setCatName(String name) {
		this.name = name;
	}
	
	// description
	public String getCatDescription() {
		return description;
	}

	public void setCatDescription(String description) {
		this.description = description;
	}
	
	// image path
	public String getCatImagePath() {
		return imagePath;
	}

	public void setCatImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	// sound path
	public String getCatSoundPath() {
		return soundPath;
	}

	public void setCatSoundPath(String soundPath) {
		this.soundPath = soundPath;
	}

	public ArrayList<Food> getFoodsContained() {
		return foodsContained;
	}
}
