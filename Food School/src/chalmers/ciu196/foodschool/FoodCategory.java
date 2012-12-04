package chalmers.ciu196.foodschool;

public class FoodCategory {
	
	// PROBABLY NEEDS DISCUSSION WITH THE GROUP
	
	private String name, // Name of the category
	   description, // Description of the category
	   imagePath, // Path where the category icon is stored
	   soundPath; // Path where the sound file of the category is stored
	
	
	public String getSoundPath() {
		return soundPath;
	}

	public void setSoundPath(String soundPath) {
		this.soundPath = soundPath;
	}

		// Constructor
		public FoodCategory(String catName, String catDesc, String cImagePath){
			
			this.setName(catName);
			this.setDescription(catDesc);
			this.setImagePath(cImagePath);
			
		}
		
	// Default constructor
		public FoodCategory(){
				
			this.setName("Unknown");
			this.setDescription("Unknown");
			this.setImagePath("none");
			this.setSoundPath("unknown");
		}
	
		
	// Getters and Setters	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



}
