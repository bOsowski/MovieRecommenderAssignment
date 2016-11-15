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
		mainMenu();
	}
	
	private void mainMenu(){
		int choice;
				System.out.println("\n1) Add user");
				System.out.println("2) Remove user");	//not implemented
				System.out.println("3) View users");
				System.out.println("4) Add movie");
				System.out.println("5) Add rating");	//not implemented
				System.out.println("6) See all movies");
				System.out.println("7) Search for a movie");	//not implemented
				System.out.println("8) Get user ratings");	//not fully implemented
				System.out.println("9) Get user recommendations");	//not implemented
				System.out.println("10) Show top 10 movies");	//not implemented
				System.out.print("Choice: ");
		choice = input.nextInt();
		@SuppressWarnings("unused") 
		String scannerfix = input.nextLine(); //fixes a bug which caused the console to skip input
		
		switch(choice){
		case 1:	
			System.out.println("  Adding a new user..");
			addUser();
			break;
			
		case 2:
			System.out.println("  Removing a user..");
			System.out.println("  NOT YET IMPLEMENTED");
			break;
			
		case 3:
			System.out.println("  Viewing users..");
			System.out.println(load.getUsers());
			break;
		
		case 4:
			System.out.println("  Adding a new movie..");
			addMovie();
			break;
			
		case 5:
			System.out.println("  Adding a rating..");
			System.out.println("  NOT YET IMPLEMENTED");
			break;
			
		case 6:
			System.out.println("  Getting aLL movies..");
			System.out.println(load.getItems());
			break;
			
		case 7:
			System.out.println("  Searching for a movie..");
			System.out.println("  NOT YET IMPLEMENTED");
			break;
			
		case 8:
			System.out.println("  Getting user ratings..");
			System.out.println("  NOT YET FULLY IMPLEMENTED");
			System.out.println(load.getRatings());
			break;
			
		case 9:
			System.out.println("  Getting user recommendations..");
			System.out.println("  NOT YET IMPLEMENTED");
			break;
			
		case 10:
			System.out.println("  Showing top 10 movies..");
			System.out.println("  NOT YET IMPLEMENTED");
			break;
			
		}
		mainMenu();
	}
	
	private void addUser(){
		
		System.out.print("Your first name: ");
		String userName = input.nextLine();
		System.out.print("Your surname: ");
		String userSurname = input.nextLine();
		System.out.print("Your age: ");
		int userAge = input.nextInt();
		
		@SuppressWarnings("unused") 
		String scannerfix = input.nextLine(); //fixes a bug which caused the console to skip input
		
		System.out.print("Your gender? (M/F)");
		char userGender = input.nextLine().charAt(0);
		System.out.print("Your occupation: ");
		String userOccupation = input.nextLine();
		System.out.print("Your zip code: ");
		int userZipCode = input.nextInt();
		
		@SuppressWarnings("unused") 
		String scannerfix1 = input.nextLine(); //fixes a bug which caused the console to skip input
		
		System.out.println("Are you sure you want to add this user?(y/n)");
		String choice = input.nextLine();
		if(choice.contains("y")){
		load.getUsers().add(new User(load.getUsers().size()+1,userName,userSurname,userAge,userGender,userOccupation,userZipCode));
		System.out.println("New user added!");
		}
		else if(choice.contains("n")){
			System.out.println("The user was not added!");
		}
		
	}
	
	private void addMovie(){
		
		System.out.print("Title of the movie: ");
		String movieTitle = input.nextLine();
		System.out.print("Release date: ");
		int movieReleaseDate = input.nextInt();
		
		@SuppressWarnings("unused") 
		String scannerfix = input.nextLine(); //fixes a bug which caused the console to skip input
		
		System.out.print("Video release date(dd-Month-yyyy): ");
		String videoReleaseDate = input.nextLine();
		System.out.print("Movie URL link: ");
		String movieUrl = input.nextLine();
		System.out.print("Movie Genres(genre1,genre2...): ");
		String movieGenres = input.nextLine();
	
		short unknown = 0;
		short action = 0;
		short adventure = 0;
		short animation = 0;
		short childrens = 0;
		short comedy = 0;
		short crime = 0;
		short documentary = 0;
		short drama = 0;
		short fantasy = 0;
		short film_noir = 0;
		short horror = 0;
		short musical = 0;
		short mystery = 0;
		short romance = 0;
		short sci_fi = 0;
		short thriller = 0;
		short war = 0;
		short western = 0;
		
		if(movieGenres.contains("unknown")){
			unknown = 1;
		}
		if(movieGenres.contains("action")){
			 action = 1;
		}
		if(movieGenres.contains("advent")){
			 adventure = 1;
		}
		if(movieGenres.contains("animat")){
			 animation = 1;
		}
		if(movieGenres.contains("child")){
			 childrens = 1;
		}
		if(movieGenres.contains("comed")){
			 comedy = 1;
		}
		if(movieGenres.contains("crime")){
			 crime = 1;
		}
		if(movieGenres.contains("docu")){
			 documentary = 1;
		}
		if(movieGenres.contains("drama")){
			 drama = 1;
		}
		if(movieGenres.contains("fant")){
			 fantasy = 1;
		}
		if(movieGenres.contains("noir")){
			 film_noir = 1;
		}
		if(movieGenres.contains("horror")){
			 horror = 1;
		}
		if(movieGenres.contains("music")){
			 musical = 1;
		}
		if(movieGenres.contains("myster")){
			 mystery = 1;
		}
		if(movieGenres.contains("roman")){
			 romance = 1;
		}
		if(movieGenres.contains("sci") && movieGenres.contains("fi")){
			 sci_fi = 1;
		}
		if(movieGenres.contains("thrill")){
			 thriller = 1;
		}
		if(movieGenres.contains("war")){
			 war = 1;
		}
		if(movieGenres.contains("west")){
			 western = 1;
		}
		
		System.out.println("Are you sure you want to add this movie?(y/n)");
		String choice = input.nextLine();
		if(choice.contains("y")){
		load.getItems().add(new Item(load.getItems().size()+1,movieTitle,movieReleaseDate,videoReleaseDate,movieUrl,unknown,action,adventure,animation,childrens,comedy,crime,documentary,drama,fantasy,film_noir,horror,musical,mystery,romance,sci_fi,thriller,war,western));	
		System.out.println("New movie added!");
		}
		else if(choice.contains("n")){
			System.out.println("The movie was not added!");
		}
	}

}
