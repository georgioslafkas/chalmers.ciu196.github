package chalmers.ciu196.foodschool;

public class Food {
	
	// PROBABLY NEEDS DISCUSSION WITH THE GROUP
		
		private String name, // Name of the food
		   description, // Description of the food
		   sound_path, // Path of the sound file for this food
		   category; // Category indicator where this food belongs
		
		private int number_of_questions = 4; // Number of available questions and answers for this food
		
		private String questions[] = new String[number_of_questions]; // Array that holds questions
		private String answers[] = new String[number_of_questions]; // Array that holds answers
		
		private int number_of_pictures = 6; // Number of pictures used for this food including the icon , description image and gallery images 
		private String image_paths[] = new String[number_of_pictures]; //Array that holds the paths for the pictures used
		
		
		// Getters and Setters of the parameters above
		
		public String getName() { // Returns the name of the food
			return name;
		}
		public void setName(String name) { // Sets the name of the food according to the String given
			this.name = name;
		}
		public String getDescription() { // Returns the description of the food
			return description;
		}
		public void setDescription(String description) { // Sets the description of the food according to the String given
			this.description = description;
		}
		public String getSound_path() { // Returns the path of the sound file
			return sound_path;
		}
		public void setSound_path(String sound_path) {
			this.sound_path = sound_path;
		}
		public String getCategory() { // Returns the category
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public int getNumber_of_questions() { // Returns the number of questions available for the food
			return number_of_questions;
		}
		public void setNumber_of_questions(int number_of_questions) {
			this.number_of_questions = number_of_questions;
		}
		public String[] getQuestions() { // Returns the string array of questions related to this food
			return questions;
		}
		public void setQuestions(String[] questions) {
			this.questions = questions;
		}
		public String[] getAnswers() { // Returns the string array of answers related to this food
			return answers;
		}
		public void setAnswers(String[] answers) { 
			this.answers = answers;
		}
		public int getNumber_of_pictures() { // Returns the number of pictures available for this food
			return number_of_pictures;
		}
		public void setNumber_of_pictures(int number_of_pictures) {
			this.number_of_pictures = number_of_pictures;
		}
		public String[] getImage_paths() { // Returns the string array with the paths of the images
			return image_paths;
		}
		public void setImage_paths(String[] image_paths) { 
			this.image_paths = image_paths;
		}
		
		// Constructor
		
		public Food(String fname, String fdescription, String fsound_path, String fcategory , int fnumber_of_questions,int fnumber_of_pictures  ){
			
			this.setName(fname);
			this.setDescription(fdescription);
			this.setSound_path(fsound_path);
			this.setCategory(fcategory);
			this.setNumber_of_questions(fnumber_of_questions);
			this.setNumber_of_pictures(fnumber_of_pictures);
		}
		
		
} // End of class
