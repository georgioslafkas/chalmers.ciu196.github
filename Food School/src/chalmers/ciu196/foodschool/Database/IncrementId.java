package chalmers.ciu196.foodschool.Database;

public class IncrementId extends Object{
	
	public int id;

	public void IncrementedId() {
		this.id = 0;
	}

	// end IncrementedId

	public int getNextID() {
		return ++id;
	}

	public void resetId(){
		id = 0;
	}

}
