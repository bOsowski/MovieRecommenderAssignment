package app;

import java.util.Scanner;

import app.wrapperClasses.Item;
import app.wrapperClasses.User;

public class Driver {
	private Scanner input = new Scanner(System.in);
	private Load load;
	
	public static void main(String[] args) {
		new Driver();
	}
	
	
	//Class Constructor
	public Driver(){
		load = new Load();
		displayStartScreen();
		mainMenu();
	}
	
	private void mainMenu(){
	
		int choice=0;			
				
				System.out.println("\n1) Add user");
				System.out.println("2) Remove user");	//not implemented
				System.out.println("3) View users");
				System.out.println("4) Add movie");
				System.out.println("5) Add rating");
				System.out.println("6) See all movies");
				System.out.println("7) Search for a movie");	//not implemented
				System.out.println("8) Get user ratings");	//not fully implemented
				System.out.println("9) Get user recommendations");	//not implemented
				System.out.println("10) Show top 10 movies");	//not implemented
				System.out.print("Choice: ");
		try
		{
			choice = input.nextInt();
		}catch(Exception e)
		{
			System.err.println("	Invalid Command.	\n---Only numerals are allowed!---");
		}
		input.nextLine(); //fixes a bug which caused the console to skip input
		
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
			addRating();
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
		
		input.nextLine(); //fixes a bug which caused the console to skip input

		
		System.out.print("Your gender? (M/F): ");
		char userGender = input.nextLine().toUpperCase().charAt(0);
		//accepting only valid input.. implement in the future for other values
		while(!(Character.toString(userGender).matches("M")) && !(Character.toString(userGender).matches("F"))){
			System.err.println("\n|      Invalid Input.     |\n|                  	  |\n|---Type in 'M' or 'F'!---|\n|                  	  |\n|       Press Enter.      |");
			input.nextLine();
			System.out.print("Your gender? (M/F): ");
			userGender = input.nextLine().toUpperCase().charAt(0);
		}
		System.out.print("Your occupation: ");
		String userOccupation = input.nextLine();
		System.out.print("Your zip code: ");
		int userZipCode = input.nextInt();
		
		input.nextLine(); //fixes a bug which caused the console to skip input
		
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
		
		input.nextLine(); //fixes a bug which caused the console to skip input
		
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

	
	private void addRating(){
		
		System.out.println("What is your name?: ");
		String userName = input.nextLine();
		System.out.println("What is your surname?: ");
		String userSurname = input.nextLine();
		boolean userExists = false;
		
		for(int i = 0; i < load.getUsers().size(); i++){
			
			if(userName.equals(load.getUsers().get(i).getName()) && userSurname.equals(load.getUsers().get(i).getSurname())){
				int userId = load.getUsers().get(i).getUserId();
				userExists = true;
				break;
			}
			
		}
		
		if(userExists == false){
				System.err.println("This user doesn't exist!\n");
				System.out.println("Do you want to create a new user?(Y/N): ");
				
				char userInput = input.nextLine().toUpperCase().charAt(0);
				while(!(Character.toString(userInput).matches("Y")) && !(Character.toString(userInput).matches("N"))){
					System.err.println("\n|      Invalid Input.     |\n|                  	  |\n|---Type in 'M' or 'F'!---|\n|                  	  |\n|       Press Enter.      |");
					input.nextLine();
					System.err.println("This user doesn't exist!\n");
					System.out.println("Do you want to create a new user?(Y/N): ");
					userInput = input.nextLine().toUpperCase().charAt(0);
				}
					if(Character.toString(userInput).matches("Y")){
						addUser();
					}
					else{
						if(goBackToTheMainMenu() == true) mainMenu();
						else addRating();
					}		
		}		
		
		System.out.println("What is the movie you'd like to review?//NOT IMPLEMENTED");
		input.nextLine();
		
	}
	
	
	private boolean goBackToTheMainMenu(){
		System.out.println("Do you want to go back to the main menu?(Y/N): ");
		char userInput = input.nextLine().toUpperCase().charAt(0);
		//accepting only valid input.. implement in the future for other values
		while(!(Character.toString(userInput).matches("Y")) && !(Character.toString(userInput).matches("N"))){
			System.err.println("\n|      Invalid Input.     |\n|                  	  |\n|---Type in 'M' or 'F'!---|\n|                  	  |\n|       Press Enter.      |");
			input.nextLine();
			System.out.print("Your gender? (M/F): ");
			userInput = input.nextLine().toUpperCase().charAt(0);
		}
		if((Character.toString(userInput).matches("Y"))){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public void displayStartScreen(){
		System.out.println();
		System.err.println(" ███▄ ▄███▓ ▒█████   ██▒   █▓ ██▓▓█████     ██▀███  ▓█████  ▄████▄   ▒█████   ███▄ ▄███▓ ███▄ ▄███▓▓█████  ███▄    █ ▓█████▄ ▓█████  ██▀███  ");
		System.err.println("▓██▒▀█▀ ██▒▒██▒  ██▒▓██░   █▒▓██▒▓█   ▀    ▓██ ▒ ██▒▓█   ▀ ▒██▀ ▀█  ▒██▒  ██▒▓██▒▀█▀ ██▒▓██▒▀█▀ ██▒▓█   ▀  ██ ▀█   █ ▒██▀ ██▌▓█   ▀ ▓██ ▒ ██▒");
		System.err.println("▓██    ▓██░▒██░  ██▒ ▓██  █▒░▒██▒▒███      ▓██ ░▄█ ▒▒███   ▒▓█    ▄ ▒██░  ██▒▓██    ▓██░▓██    ▓██░▒███   ▓██  ▀█ ██▒░██   █▌▒███   ▓██ ░▄█ ▒");
		System.err.println("▒██    ▒██ ▒██   ██░  ▒██ █░░░██░▒▓█  ▄    ▒██▀▀█▄  ▒▓█  ▄ ▒▓▓▄ ▄██▒▒██   ██░▒██    ▒██ ▒██    ▒██ ▒▓█  ▄ ▓██▒  ▐▌██▒░▓█▄   ▌▒▓█  ▄ ▒██▀▀█▄ ");
		System.err.println("▒██▒   ░██▒░ ████▓▒░   ▒▀█░  ░██░░▒████▒   ░██▓ ▒██▒░▒████▒▒ ▓███▀ ░░ ████▓▒░▒██▒   ░██▒▒██▒   ░██▒░▒████▒▒██░   ▓██░░▒████▓ ░▒████▒░██▓ ▒██▒");
		System.err.println("░ ▒░   ░  ░░ ▒░▒░▒░    ░ ▐░  ░▓  ░░ ▒░ ░   ░ ▒▓ ░▒▓░░░ ▒░ ░░ ░▒ ▒  ░░ ▒░▒░▒░ ░ ▒░   ░  ░░ ▒░   ░  ░░░ ▒░ ░░ ▒░   ▒ ▒  ▒▒▓  ▒ ░░ ▒░ ░░ ▒▓ ░▒▓░");
		System.err.println("░  ░      ░  ░ ▒ ▒░    ░ ░░   ▒ ░ ░ ░  ░     ░▒ ░ ▒░ ░ ░  ░  ░  ▒     ░ ▒ ▒░ ░  ░      ░░  ░      ░ ░ ░  ░░ ░░   ░ ▒░ ░ ▒  ▒  ░ ░  ░  ░▒ ░ ▒░");
		System.err.println("░      ░   ░ ░ ░ ▒       ░░   ▒ ░   ░        ░░   ░    ░   ░        ░ ░ ░ ▒  ░      ░   ░      ░      ░      ░   ░ ░  ░ ░  ░    ░     ░░   ░ ");
		System.err.println("       ░       ░ ░        ░   ░     ░  ░      ░        ░  ░░ ░          ░ ░         ░          ░      ░  ░         ░    ░       ░  ░   ░     ");
		System.err.println("                         ░                                 ░                                                          ░                      ");
		System.err.println("                                                                 PRESS ENTER                                                                 ");
		input.nextLine();
	}
}
