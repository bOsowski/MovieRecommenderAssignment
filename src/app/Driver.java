package app;

import java.util.Scanner;

import app.wrapperClasses.Item;
import app.wrapperClasses.Rating;
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
			System.out.println("  Getting all movies..");
			System.out.println(load.getItems());
			break;
			
		case 7:
			System.out.println("  Searching for a movie..");
			System.out.println("  NOT YET IMPLEMENTED");
			break;
			
		case 8:
			System.out.println("  Getting user ratings..");
			System.out.println("  NOT YET FULLY IMPLEMENTED");
			addMovieTitlesToRatings();
			// set the title of the rating object to the value of the title of the item with the rating's movie Id
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
	
	private void displayAllMovies(){
		//System.out.print("Display movies based onz")
	}
	
	private void addMovieTitlesToRatings(){
	for(int i =0; i<load.getRatings().size();i++){
	load.getRatings().get(i).setMovieTitle(load.getItems().get(load.getRatings().get(i).getItemId()-1).getMovieTitle());
		
		
	}
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
		
		//Getting the user information to add a rating as
		System.out.println("What is your name?: ");
		String userName = input.nextLine();
		System.out.println("What is your surname?: ");
		String userSurname = input.nextLine();
		boolean userExists = false;
		int userId = 0;
		//Check if the specified user exists..
		for(int i = 0; i < load.getUsers().size(); i++){
			
			if(userName.equals(load.getUsers().get(i).getName()) && userSurname.equals(load.getUsers().get(i).getSurname())){
				userId = load.getUsers().get(i).getUserId();
				userExists = true;
				break;
			}
			
		}
		//If the user doesn't exist, ask if to create a new user or to go to the main menu or to add a rating again
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
		
		System.out.println("Type in a movie title to search for: ");
		String movieTitle = input.nextLine();
		System.out.println("Matching movies: \n");
		//Check if the specified movie exists..
		for(int i = 0; i < load.getItems().size(); i++){
			
			//if(movieTitle.contains(load.getItems().get(i).getMovieTitle())){
			if(load.getItems().get(i).getMovieTitle().contains(movieTitle)){
				System.out.println("Movie Title: "+load.getItems().get(i).getMovieTitle()+" ("+load.getItems().get(i).getReleaseDate()+") "+"*** Movie ID: "+load.getItems().get(i).getMovieId()+"***");					
			}
			
		}
		
		System.out.print("Type in the movie ID you want to add a rating for: ");
		int movieId = input.nextInt()-1;
		boolean correctInput = false;

		for(int i = 0; i < load.getItems().size(); i++){
			
			if(load.getItems().get(i).getMovieId() == movieId){
				correctInput = true;
				break;
			}	
		}	
		if(!correctInput){
			System.err.println("This movie ID doesn't exist!\n Going back to the menu..");
			mainMenu();			
		}
		
		System.out.print("Rate the movie "+ load.getItems().get(movieId).getMovieTitle()+" from -5 to 5: " );
		short userRating = input.nextShort();
		input.nextLine();
		
		//dividing by 1000L gets the unix time.
		long unixTime = System.currentTimeMillis() / 1000L;
		
		System.out.println("Do you want to give the movie "+ load.getItems().get(movieId).getMovieTitle()+" ("+load.getItems().get(movieId).getReleaseDate()+") a rating of "+userRating+"?(Y/N)");
		char userInput = input.nextLine().toUpperCase().charAt(0);
		while(!(Character.toString(userInput).matches("Y")) && !(Character.toString(userInput).matches("N"))){
			System.err.println("\n|      Invalid Input.     |\n|                  	  |\n|---Type in 'M' or 'F'!---|\n|                  	  |\n|       Press Enter.      |");
			input.nextLine();
			System.out.println("Do you want to give the movie "+ load.getItems().get(movieId).getMovieTitle()+" ("+load.getItems().get(movieId).getReleaseDate()+") a rating of "+userRating+"?(Y/N)");
			userInput = input.nextLine().toUpperCase().charAt(0);
		}
		if(Character.toString(userInput).matches("Y")){
			//add a new rating of the user definied parameters. MovieID+1 because indexing starts at 0 where Ids start from 1.
		load.getRatings().add(new Rating(userId,movieId+1,userRating,unixTime));
		System.out.println("Review added!");
		}
		else{
			System.out.println("The review was not added. Going back to the main menu..");
		}
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
