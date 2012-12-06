package chalmers.ciu196.foodschool;



public class FoodCategory extends Object{ 
	
	// PROBABLY NEEDS DISCUSSION WITH THE GROUP
	
	private String name, // Name of the category
	   description, // Description of the category
	   imagePath, // Path where the category icon is stored
	   soundPath; // Path where the sound file of the category is stored
	
	private int catId; // Category id


	// Constructor
	public FoodCategory(String catName, String catDesc, String cImagePath){
			
		this.setName(catName);
		this.setDescription(catDesc);
		this.setImagePath(cImagePath);			
	}
		
	// Default constructor
	public FoodCategory(){
			
		this.setName(null);
		this.setDescription(null);
		this.setImagePath(null);
		this.setSoundPath(null);
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// description
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	// image path
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	// sound path
	public String getSoundPath() {
		return soundPath;
	}

	public void setSoundPath(String soundPath) {
		this.soundPath = soundPath;
	}

}
