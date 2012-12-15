package chalmers.ciu196.foodschool;

import java.io.Serializable;
import java.util.ArrayList;


public class Food extends Object implements Serializable { 
	
	// PROBABLY NEEDS DISCUSSION WITH THE GROUP
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String name, // Name of the food
		   description, // Description of the food
		   category; // Category indicator where this food belongs
		private int foodId; // Id of the food
		private String foodRef;

		private ArrayList<String> questions = new ArrayList<String>(); // Array that holds questions
		private ArrayList<String> answers = new ArrayList<String>();// Array that holds answers
		 
		private ArrayList<String> image_paths = new ArrayList<String>(); // Array that holds the paths for the pictures used
		private ArrayList<String> sound_paths = new ArrayList<String>(); // Array that holds the paths for the sounds used		
		
		// Getters and Setters of the parameters above
		public String getfoodRef(){
			return foodRef;
		}
		// id
		public int getId() {
			return foodId;
		}
		public void setId(int id) {
			this.foodId = id;
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
		
		// sound_paths
		public ArrayList<String> getSound_paths() {
			return sound_paths;
		}
		public void setSound_paths(ArrayList<String> sound_paths) {
			this.sound_paths = sound_paths;
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
		
		public Food( String fname, String fdescription, String fcategory , int ID, ArrayList<String> fsound_paths, ArrayList<String> qstns , ArrayList<String> answrs , ArrayList<String> img_paths   ){
			
			this.setId(ID);
			this.setName(fname);
			this.setDescription(fdescription);
			this.setSound_paths(fsound_paths);
			this.setCategory(fcategory);
			this.setAnswers(answrs);
			this.setQuestions(qstns);
		}
		
		// Default constructor
		public Food(){
			this.setId(0);
			this.setName(null);
			this.setDescription(null);
			this.setSound_paths(null);
			this.setCategory(null);
			this.setAnswers(null);
			this.setQuestions(null);
		}
		
		
} // End of class
