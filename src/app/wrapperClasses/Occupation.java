package app.wrapperClasses;

public class Occupation {
	
	

	private String occupation;

	public Occupation(String occupationDetails) {
		this.occupation = occupationDetails;
	}
	
	

	@Override
	public String toString() {
		return "\nOccupation [occupation=" + occupation + "]";
	}



	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
	

}
