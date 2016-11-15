package app;

import java.util.Scanner;

import app.wrapperClasses.Item;
import app.wrapperClasses.User;

public class Driver {
	private Scanner input = new Scanner(System.in);
	private Load load;
	//Main
	public static void main(String[] args) {
		new Driver();
	}
	
	
	//Class Constructor
	public Driver(){
		load = new Load();
		//createUser();
		addMovie();
	}
	
	private void createUser(){
		
		System.out.print("Your first name: ");
		String userName = input.nextLine();
		System.out.print("Your surname: ");
		String userSurname = input.nextLine();
		System.out.print("Your age: ");
		int userAge = input.nextInt();
		
		@SuppressWarnings("unused") 
		String scannerfix = input.nextLine(); //fixes a bug which caused the console to skip gender
		
		System.out.print("Your gender? (M/F)");
		char userGender = input.nextLine().charAt(0);
		System.out.print("Your occupation: ");
		String userOccupation = input.nextLine();
		System.out.print("Your zip code: ");
		int userZipCode = input.nextInt();
		
		load.getUsers().add(new User(load.getUsers().size()+1,userName,userSurname,userAge,userGender,userOccupation,userZipCode));
		System.out.println(load.getUsers());
	}
	
	private void addMovie(){
		
		System.out.print("Title of the movie: ");
		String movieTitle = input.nextLine();
		System.out.print("Release date: ");
		int movieReleaseDate = input.nextInt();
		
		@SuppressWarnings("unused") 
		String scannerfix = input.nextLine(); //fixes a bug which caused the console to skip gender
		
		System.out.print("Video release date(dd-mm-yyyy): ");
		String videoReleaseDate = input.nextLine();
		System.out.print("Movie URL link: ");
		String movieUrl = input.nextLine();
		System.out.print("Movie Genres(genre1,genre2...): ");
		String movieGenres = input.nextLine();
	
		short unknown;
		short action;
		short adventure;
		short animation;
		short childrens;
		short comedy;
		short crime;
		short documentary;
		short drama;
		short fantasy;
		short film_noir;
		short horror;
		short musical;
		short mystery;
		short romance;
		short sci_fi;
		short thriller;
		short war;
		short western;
		
		if(movieGenres.contains("unknown")){
			unknown = 1;
		}
		else{ 
			 unknown = 0;
		}
		if(movieGenres.contains("action")){
			 action = 1;
		}
		else{ 
			 action = 0;
		}
		if(movieGenres.contains("advent")){
			 adventure = 1;
		}
		else{ 
			 adventure = 0;
		}
		if(movieGenres.contains("animat")){
			 animation = 1;
		}
		else{ 
			 animation = 0;
		}
		if(movieGenres.contains("child")){
			 childrens = 1;
		}
		else{
			 childrens = 0;
		}
		if(movieGenres.contains("comed")){
			 comedy = 1;
		}
		else{
			 comedy = 0;
		}
		if(movieGenres.contains("crime")){
			 crime = 1;
		}
		else{
			 crime = 0;
		}
		if(movieGenres.contains("docu")){
			 documentary = 1;
		}
		else{
			 documentary = 0;
		}
		if(movieGenres.contains("drama")){
			 drama = 1;
		}
		else{
			 drama = 0;
		}
		if(movieGenres.contains("fant")){
			 fantasy = 1;
		}
		else{
			 fantasy = 0;
		}
		if(movieGenres.contains("noir")){
			 film_noir = 1;
		}
		else{
			 film_noir = 0;
		}
		if(movieGenres.contains("horror")){
			 horror = 1;
		}
		else{
			 horror = 0;
		}
		if(movieGenres.contains("music")){
			 musical = 1;
		}
		else{
			 musical = 0;
		}
		if(movieGenres.contains("myster")){
			 mystery = 1;
		}
		else{
			 mystery = 0;
		}
		if(movieGenres.contains("roman")){
			 romance = 1;
		}
		else{
			 romance = 0;
		}
		if(movieGenres.contains("sci") && movieGenres.contains("fi")){
			 sci_fi = 1;
		}
		else{
			 sci_fi = 0;
		}
		if(movieGenres.contains("thrill")){
			 thriller = 1;
		}
		else{
			 thriller = 0;
		}
		if(movieGenres.contains("war")){
			 war = 1;
		}
		else{
			 war = 0;
		}
		if(movieGenres.contains("west")){
			 western = 1;
		}
		else{
			 western = 0;
		}

		load.getItems().add(new Item(load.getItems().size(),movieTitle,movieReleaseDate,videoReleaseDate,movieUrl,unknown,action,adventure,animation,childrens,comedy,crime,documentary,drama,fantasy,film_noir,horror,musical,mystery,romance,sci_fi,thriller,war,western));
		
		System.out.print(load.getItems());
		
	}

}
