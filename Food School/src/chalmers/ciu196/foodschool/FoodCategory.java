package chalmers.ciu196.foodschool;

import java.util.ArrayList;



public class FoodCategory extends Object{ 
	
	// PROBABLY NEEDS DISCUSSION WITH THE GROUP
	
	private String name, // Name of the category
	   description, // Description of the category
	   imagePath, // Path where the category icon is stored
	   soundPath; // Path where the sound file of the category is stored
	private int imageid, //Id of the image resource
		soundid; //Id of the sound resource

	private ArrayList<Food> foodsContained = new ArrayList<Food>();

	// Constructor
	public FoodCategory(String catName, String catDesc, String cImagePath, String cSoundPath,
						ArrayList<Food> foodsC){
			
		this.setCatName(catName);
		this.setCatDescription(catDesc);
		this.setCatImagePath(cImagePath);		
		this.setCatSoundPath(cSoundPath);
		this.setFoodsContained(foodsC);
	}
		
	// Default constructor
	public FoodCategory(){
			
		this.setCatName(null);
		this.setCatDescription(null);
		this.setCatImagePath(null);
		this.setCatSoundPath(null);
		this.setFoodsContained(null);
	}	
		
	// Getters and Setters	
		
	public int getImageid(){
		return imageid;
	}
	
	public void setImageid(int id){
		imageid=id;
	}
	
	public int getSoundid(){
		return soundid;
	}
	
	public void setSoundid(int id){
		soundid=id;
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
	
	public void setFoodsContained(ArrayList<Food> foods)
	{
		this.foodsContained = foods;
	}
}
