package app.wrapperClasses;

public class User {

	private int userId;
	private String name;
	private String surname;
	private int age;
	private char gender;
	private String occupation;
	private int zipCode;
	
	public User(int userId, String name, String surname, int age, char gender, String occupation, int zipCode){
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.zipCode = zipCode;
		
	}

	@Override
	public String toString() {
		return "\nUser [userId=" + userId + ", name=" + name + ", surname=" + surname + ", age=" + age + ", gender="
				+ gender + ", occupation=" + occupation + ", zipCode=" + zipCode + "]";
	}

	
//Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
//End of Getters and Setters
	
}
