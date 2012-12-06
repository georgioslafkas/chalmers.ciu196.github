package chalmers.ciu196.foodschool;

import java.util.ArrayList;


public class Food extends Object{ 
	
	// PROBABLY NEEDS DISCUSSION WITH THE GROUP
		
		private String name, // Name of the food
		   description, // Description of the food
		   sound_path, // Path of the sound file for this food
		   category; // Category indicator where this food belongs
		private int id; // Id of the food
		

		private ArrayList<String> questions = new ArrayList<String>(); // Array that holds questions
		private ArrayList<String> answers = new ArrayList<String>();// Array that holds answers
		 
		private ArrayList<String> image_paths = new ArrayList<String>(); //Array that holds the paths for the pictures used
		
		
		// Getters and Setters of the parameters above
		
		// id
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		// name
		public String getName() { // Returns the name of the food
			return name;
		}
		public void setName(String name) { // Sets the name of the food according to the String given
			this.name = name;
		}
		
		// description
		public String getDescription() { // Returns the description of the food
			return description;
		}
		public void setDescription(String description) { // Sets the description of the food according to the String given
			this.description = description;
		}
		
		// sound_path
		public String getSound_path() { // Returns the path of the sound file
			return sound_path;
		}
		public void setSound_path(String sound_path) { // Set the path of the sound file
			this.sound_path = sound_path;
		}
		
		// category
		public String getCategory() { // Returns the category that this food belongs
			return category;
		}
		public void setCategory(String category) { // Set the category that this food belongs
			this.category = category;
		}
		
		// questions
		public ArrayList<String> getQuestions() { // Returns the array with the questions 
			return questions;
		}
		public void setQuestions(ArrayList<String> questions) { // Sets the array with the questions
			this.questions = questions;
		}
		
		// answers
		public ArrayList<String> getAnswers() { // Returns the array with the answers
			return answers;
		}
		public void setAnswers(ArrayList<String> answers) { // Sets the array with the answers
			this.answers = answers;
		}
		
		// image_paths
		public void setImage_paths(ArrayList<String> image_paths) { // Sets the image path
			this.image_paths = image_paths;
		}
		public ArrayList<String> getImage_paths() { // Returns the array with the paths of the images
			return image_paths;
		}
	
		
		// Constructor
		
		public Food(int ID, String fname, String fdescription, String fsound_path, String fcategory , int fnumber_of_questions,int fnumber_of_pictures  ){
			
			this.setId(ID);
			this.setName(fname);
			this.setDescription(fdescription);
			this.setSound_path(fsound_path);
			this.setCategory(fcategory);
		}
		
		// Default constructor
		public Food(){
			this.setId(0);
			this.setName(null);
			this.setDescription(null);
			this.setSound_path(null);
			this.setCategory(null);
		}
		
		
} // End of class
