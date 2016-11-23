package app.wrapperClasses;

import java.io.Serializable;

public class User implements Serializable{


	private static final long serialVersionUID = 1217871336685806741L;
	private int userId;
	private String name;
	private String surname;
	private int age;
	private char gender;
	private String occupation;
	private String zipCode;
	
	public User(int userId, String name, String surname, int age, char gender, String occupation, String zipCode){
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.age = age;
		setGender(gender);
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
		if(gender == 'm' || gender == 'M'){
			this.gender = 'M';
		}
		else if(gender == 'f' || gender == 'F'){
			this.gender = 'F';
		}
		else this.gender = 'U';
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
//End of Getters and Setters
	
}
