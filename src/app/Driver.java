package app;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import app.wrapperClasses.Item;
import app.wrapperClasses.Rating;
import app.wrapperClasses.User;

public class Driver {
	private Scanner input = new Scanner(System.in);
	private Load load;
	int amountOfLikedMoviesForRecommendation = 20;
	
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
				System.out.println("2) Remove user");
				System.out.println("3) View users");
				System.out.println("4) Add movie");
				System.out.println("5) Add rating");
				System.out.println("6) See all movies");
				System.out.println("7) Search for a movie");
				System.out.println("8) Get user ratings");
				System.out.println("9) Get user recommendations");	//not implemented
				System.out.println("10) Show top 10 movies");
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
			removeUser();
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
			load.addOverallRating();
			break;
			
		case 6:
			System.out.println("  Getting all movies..");
			displayAllMovies();
			break;
			
		case 7:
			System.out.println("  Searching for a movie..");
			searchForMovies();
			break;
			
		case 8:
			System.out.println("  Getting user ratings..");
			addMovieTitlesToRatings();
			// set the title of the rating object to the value of the title of the item with the rating's movie Id
			System.out.println(load.getRatings());
			break;
			
		case 9:
			userRecommendationsMenu();
			break;
			
		case 10:
			System.out.println("  Showing top 10 movies..");
			displayTop10Movies();
			break;
			
		}
		mainMenu();
	}
	
	private void userRecommendationsMenu(){
		int choice = 0;
		
		System.out.println("\nRecommend movies based on: ");
		System.out.println("1) Genre preference");
		System.out.println("2) Other users with similiar likes");
		
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
			recommendByGenre();
			break;
			
		case 2:
			int userId = logIn();
			while (userId == 0) userId = logIn();
			recommendAlgorithm(userId);	
			break;
		}
	}
	
	private void displayAllMovies(){
		
		int choice = 0;
		
			System.out.println("\nDisplay movies based on: ");
			System.out.println("1) Rating");
			System.out.println("2) Popularity");
			System.out.println("3) Release Date");
			
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
				System.out.println("Displaying movies based on ratings.. ");
				SelectionSort.sort(load.getItems(),"rating");
				if(load.items != null){
					for(int i = 0; i<load.items.size();i++){
						System.out.print(load.items.get(i));
					}
					}
				break;
				
			case 2:
				System.out.println("Displaying movies based on popularity.. ");
				SelectionSort.sort(load.getItems(),"popularity");
				if(load.items != null){
					for(int i = 0; i<load.items.size();i++){
						System.out.print(load.items.get(i));
					}
					}
				break;
				
			case 3:
				System.out.println("4) Release Date");
				SelectionSort.sort(load.getItems(),"date");
				if(load.items != null){
					for(int i = 0; i<load.items.size();i++){
						System.out.print(load.items.get(i));
					}
					}
				break;
			}
	}
	
	
	

	private void recommendAlgorithm(int userId){
	//see what movies did the client like.
	//see what movies did others like that also liked the client's movie
		
		//gets all rated movies of the customer	1
		ArrayList<Integer> watchedMovies = new ArrayList<Integer>(); 
		for(int i = 0; i<load.getRatings().size();i++){
			if(load.getRatings().get(i).getUserId() == userId){
				watchedMovies.add(load.getRatings().get(i).getItemId());
			}
		}
		
		//get all liked movies of the customer 1
		ArrayList<Integer> likedMovieIds = new ArrayList<Integer>(); 
		for(int i = 0; i<load.getRatings().size();i++){
			if(load.getRatings().get(i).getRating() >= 4 && load.getRatings().get(i).getUserId() == userId){
				likedMovieIds.add(load.getRatings().get(i).getItemId());
			}
		}
		//System.out.println("Current User's amount of liked movies    "+ likedMovieIds.size()+" Current User's liked movies    " + likedMovieIds );
		
		
		//get users that really liked same movies as customer <UserWithCommonLikes> and the movies they like.
		ArrayList<UserWithCommonLikes> usersWithCommonLikes = new ArrayList<UserWithCommonLikes>(); 
		
		for(Integer usersLikedMovie: likedMovieIds){
			for(int i = 0; i<load.getRatings().size();i++){
				//if the movie is the same as customer's liked movie and its rating is >= x
				if(load.getRatings().get(i).getItemId() == usersLikedMovie && load.getRatings().get(i).getRating() >= 4){
					//add the common user.
					usersWithCommonLikes.add(new UserWithCommonLikes(load.getRatings().get(i).getUserId(),Integer.toString(load.getRatings().get(i).getItemId())));
				}
				
			}
		}
		

		//System.out.println("UsersWithCommonLikes" + usersWithCommonLikes);
		
		//remove duplicate users and add all movies to the first user with the same ID
		for(int c = 0; c<usersWithCommonLikes.size();c++){
			for(int o = 1; o<usersWithCommonLikes.size();o++){
				
				if(usersWithCommonLikes.get(c).getUserId() == usersWithCommonLikes.get(o).getUserId() && !usersWithCommonLikes.get(c).equals(usersWithCommonLikes.get(o))){
					usersWithCommonLikes.get(c).addFavouriteMovies(usersWithCommonLikes.get(o).getFavouriteMovies());
					usersWithCommonLikes.remove(o);
					o--;
					
				}
				
			}
		}
		//removing the users that only have X common liked movies
		for(int i = 0; i<usersWithCommonLikes.size(); i++){
				String[] amountOfMoviesInString = usersWithCommonLikes.get(i).getFavouriteMovies().split("\\s+");
				if(amountOfMoviesInString.length <= amountOfLikedMoviesForRecommendation){
					usersWithCommonLikes.remove(i);
					i=0;
				}
		}		
		
		//get all liked movies from each similiar user
		TreeSet<Integer> recommendedMovies = new TreeSet<Integer>();
		for(UserWithCommonLikes currentOtherCommonLikes: usersWithCommonLikes){
			for(Rating currentRating: load.getRatings()){
		
				if(load.getRatings().get(currentRating.getItemId()).getUserId() == currentOtherCommonLikes.getUserId() && load.getRatings().get(currentRating.getItemId()).getRating() > 3){	
					recommendedMovies.add(currentRating.getItemId());
				}
			
			}
		}
		
	//	System.err.println("likedMovies: "+likedMovieIds);
	//	System.out.println("watchedMovies: "+watchedMovies);
	//	System.err.println("RecommendedMovies: "+recommendedMovies);
	//	System.out.println("Amount of recommendations: "+recommendedMovies.size());
		
		recommendedMovies.removeAll(watchedMovies);

		
		
		ArrayList<Item> recommendations = new ArrayList<Item>();
		for(Integer movieId: recommendedMovies){
			for(Item movie: load.getItems()){
				
				if(movie.getMovieId() == movieId){
					recommendations.add(movie);
				}
				
			}
		}
		
		if(recommendations.size() < 30){
			if(amountOfLikedMoviesForRecommendation!=0){
			amountOfLikedMoviesForRecommendation--;
			recommendAlgorithm(userId);
			}
			else {
				System.err.println("Not enough ratings for recommendations!");
				amountOfLikedMoviesForRecommendation = 20;
				mainMenu();
			}
		}
		else{
		System.out.println("Amount of recommendations: "+recommendedMovies.size());
		System.out.println("How would you like your movies sorted?(rating/popularity/date): ");
		String sortingType = input.nextLine().toLowerCase();
		while(!sortingType.contains("popularity") && !sortingType.contains("rating") && !sortingType.contains("date")){
		System.err.println("Wrong Input!");
		System.out.println("How would you like your movies sorted?(rating/popularity/date): ");
		sortingType = input.nextLine().toLowerCase();
		}
		SelectionSort.sort(recommendations, sortingType);
		System.out.println(recommendations);
		amountOfLikedMoviesForRecommendation = 20;
		}
	}
	
	
	
	
	//Get user recommendations
	private void recommendByGenre(){
		ArrayList<Item> recommendations = new ArrayList<Item>();
		//not needed to log in for this.
		//int userId = logIn();
		//while (userId == 0) userId = logIn();
		
		System.out.print("What genres are you interested in?: ");
		String likedGenres = input.nextLine();
		//likedGenres = likedGenres.toLowerCase();
		System.out.print("What genres will you definitely not watch?: ");
		String hatedGenres = input.nextLine().toLowerCase();
		//hatedGenres = hatedGenres.toLowerCase();
		boolean unknown = false,action = false,adventure = false,animation = false,childrens = false,comedy = false,crime = false,documentary = false,drama = false,fantasy = false,film_noir = false,horror = false,musical = false, mystery = false,romance = false,sci_fi = false,thriller = false,war = false,western = false;

		if(likedGenres.contains("unknown")){
			unknown = true;
		}
		if(likedGenres.contains("action")){
			 action = true;
		}
		if(likedGenres.contains("advent")){
			 adventure = true;
		}
		if(likedGenres.contains("animat")){
			 animation = true;
		}
		if(likedGenres.contains("child")){
			 childrens = true;
		}
		if(likedGenres.contains("comed")){
			 comedy = true;
		}
		if(likedGenres.contains("crime")){
			 crime = true;
		}
		if(likedGenres.contains("docu")){
			 documentary = true;
		}
		if(likedGenres.contains("drama")){
			 drama = true;
		}
		if(likedGenres.contains("fant")){
			 fantasy = true;
		}
		if(likedGenres.contains("noir")){
			 film_noir = true;
		}
		if(likedGenres.contains("horror")){
			 horror = true;
		}
		if(likedGenres.contains("music")){
			 musical = true;
		}
		if(likedGenres.contains("myster")){
			 mystery = true;
		}
		if(likedGenres.contains("roman")){
			 romance = true;
		}
		if(likedGenres.contains("sci") && likedGenres.contains("fi")){
			 sci_fi = true;
		}
		if(likedGenres.contains("thrill")){
			 thriller = true;
		}
		if(likedGenres.contains("war")){
			 war = true;
		}
		if(likedGenres.contains("west")){
			 western = true;
		}
		
//adding movies that match the liked genres into recommendations list.
		for(int i = 0;i<load.getItems().size(); i++){
			String currentGenres = load.getItems().get(i).getGenres();
			
			if(		currentGenres.contains("unknown") && unknown == true ||
					currentGenres.contains("action") && action == true ||
					currentGenres.contains("adventure") && adventure == true ||
					currentGenres.contains("animation") && animation == true ||
					currentGenres.contains("childrens") && childrens == true ||
					currentGenres.contains("comedy") && comedy == true ||
					currentGenres.contains("crime") && crime == true ||
					currentGenres.contains("documentary") && documentary == true ||
					currentGenres.contains("drama") && drama == true ||
					currentGenres.contains("fantasy") && fantasy == true ||
					currentGenres.contains("noir") && film_noir == true ||
					currentGenres.contains("horror") && horror == true ||
					currentGenres.contains("musical") && musical == true ||
					currentGenres.contains("mystery") && mystery == true ||
					currentGenres.contains("romance") && romance == true ||
					currentGenres.contains("sci fi") && sci_fi == true ||
					currentGenres.contains("thrill") && thriller == true ||
					currentGenres.contains("war") && war == true ||
					currentGenres.contains("western") && western == true){
				///////////////////////////////////END OF IF CONDITION////////////////////////////////////
				recommendations.add(load.getItems().get(i));	
				//////////////////////////////////////END OF IF CODE//////////////////////////////////////
			}
		}
		boolean unknown1 = false,action1 = false,adventure1 = false,animation1 = false,childrens1 = false,comedy1 = false,crime1 = false,documentary1 = false,drama1 = false,fantasy1 = false,film_noir1 = false,horror1 = false,musical1 = false, mystery1 = false,romance1 = false,sci_fi1 = false,thriller1 = false,war1 = false,western1 = false;
		if(hatedGenres.contains("unknown")){
			unknown1 = true;
		}
		if(hatedGenres.contains("action")){
			 action1 = true;
		}
		if(hatedGenres.contains("advent")){
			 adventure1 = true;
		}
		if(hatedGenres.contains("animat")){
			 animation1 = true;
		}
		if(hatedGenres.contains("child")){
			 childrens1 = true;
		}
		if(hatedGenres.contains("comed")){
			 comedy1 = true;
		}
		if(hatedGenres.contains("crime")){
			 crime1 = true;
		}
		if(hatedGenres.contains("docu")){
			 documentary1 = true;
		}
		if(hatedGenres.contains("drama")){
			 drama1 = true;
		}
		if(hatedGenres.contains("fant")){
			 fantasy1 = true;
		}
		if(hatedGenres.contains("noir")){
			 film_noir1 = true;
		}
		if(hatedGenres.contains("horror")){
			 horror1 = true;
		}
		if(hatedGenres.contains("music")){
			 musical1 = true;
		}
		if(hatedGenres.contains("myster")){
			 mystery1 = true;
		}
		if(hatedGenres.contains("roman")){
			 romance1 = true;
		}
		if(hatedGenres.contains("sci") && hatedGenres.contains("fi")){
			 sci_fi1 = true;
		}
		if(hatedGenres.contains("thrill")){
			 thriller1 = true;
		}
		if(hatedGenres.contains("war")){
			 war1 = true;
		}
		if(hatedGenres.contains("west")){
			 western1 = true;
		}
	
		//removing movies that match the hated genres from recommendations list.
				for(int i = 0;i<recommendations.size(); i++){
					String currentGenres = recommendations.get(i).getGenres();
					if(load.getItems().get(i).getGenres().contains("unknown") && unknown1 == true ||
							currentGenres.contains("action") && action1 == true ||
							currentGenres.contains("adventure") && adventure1 == true ||
							currentGenres.contains("animation") && animation1 == true ||
							currentGenres.contains("childrens") && childrens1 == true ||
							currentGenres.contains("comedy") && comedy1 == true ||
							currentGenres.contains("crime") && crime1 == true ||
							currentGenres.contains("documentary") && documentary1 == true ||
							currentGenres.contains("drama") && drama1 == true ||
							currentGenres.contains("fantasy") && fantasy1 == true ||
							currentGenres.contains("noir") && film_noir1 == true ||
							currentGenres.contains("horror") && horror1 == true ||
							currentGenres.contains("musical") && musical1 == true ||
							currentGenres.contains("mystery") && mystery1 == true ||
							currentGenres.contains("romance") && romance1 == true ||
							currentGenres.contains("sci fi") && sci_fi1 == true ||
							currentGenres.contains("thrill") && thriller1 == true ||
							currentGenres.contains("war") && war1 == true ||
							currentGenres.contains("western") && western1 == true){
						///////////////////////////////////END OF IF CONDITION////////////////////////////////////
						recommendations.remove(i);	
						i--;
						//////////////////////////////////////END OF IF CODE//////////////////////////////////////
					}
				}
		
		SelectionSort.sort(recommendations,"popularity");
		System.out.print(recommendations);
	}
	
	private void addMovieTitlesToRatings(){
		for(int i =0; i<load.getRatings().size();i++){
		load.getRatings().get(i).setMovieTitle(load.getItems().get(load.getRatings().get(i).getItemId()-1).getMovieTitle());
		}
	}
	

	
	private void displayTop10Movies(){
		SelectionSort.sort(load.getItems(),"popularity");
		int amountOfMoviesDisplayed = 0;
		for(int i = 0; i<load.getItems().size(); i++){
			if(load.getItems().get(i).getOverallRating() > 2){
				System.out.print(load.getItems().get(i));
				amountOfMoviesDisplayed++;
			}
			if(amountOfMoviesDisplayed == 10) break;
		}
	}
	
	private void searchForMovies(){
		System.out.println("Type in a movie title to search for: ");
		String movieTitle = input.nextLine();
		System.out.println("Matching movies: \n");
		//Check if the specified movie exists..
		for(int i = 0; i < load.getItems().size(); i++){
			String titleIgnoreCase = (load.getItems().get(i).getMovieTitle().toLowerCase());	
			if(titleIgnoreCase.contains(movieTitle.toLowerCase())){
				System.out.println(load.getItems().get(i));					
			}
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
		String userZipCode = input.nextLine();
		System.out.println("Are you sure you want to add this user?(Y/N)");
		String choice = input.nextLine();
		if(choice.contains("y") || choice.contains("Y")){
		load.getUsers().add(new User(load.getUsers().size()+1,userName,userSurname,userAge,userGender,userOccupation,userZipCode));
		System.out.println("New user added!");
		}
		else if(choice.contains("n") || choice.contains("N")){
			System.out.println("The user was not added!");
		}
		
	}
	
	private void addMovie(){
		System.out.print("Title of the movie: ");
		String movieTitle = input.nextLine();
		System.out.print("Release year: ");
		int movieReleaseYear = input.nextInt();
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
		load.getItems().add(new Item(String.valueOf(load.getItems().size()+1),movieTitle,String.valueOf(movieReleaseYear),videoReleaseDate,movieUrl,unknown,action,adventure,animation,childrens,comedy,crime,documentary,drama,fantasy,film_noir,horror,musical,mystery,romance,sci_fi,thriller,war,western));	
		System.out.println("New movie added!");
		}
		else if(choice.contains("n")){
			System.out.println("The movie was not added!");
		}
	}

	
	private void removeUser(){
		System.out.print("First name of the user to remove: ");
		String userName = input.nextLine();
		System.out.print("Surname of the user to remove: ");
		String userSurname = input.nextLine();
		boolean userExists = false;
		int userId = 0;
		//checking if user exists
		for(int i = 0; i < load.getUsers().size(); i++){
			if(userName.equals(load.getUsers().get(i).getName()) && userSurname.equals(load.getUsers().get(i).getSurname())){
				userId = load.getUsers().get(i).getUserId();
				userExists = true;
				break;
			}	
		}
		if(userExists == false){
			System.err.println("This user doesn't exist!\n");
		}
		else{
			System.out.print("Are you sure you want to delete this user?(Y/N): ");
			char userInput = input.nextLine().toUpperCase().charAt(0);
			if(Character.toString(userInput).matches("Y")){
			//remove user.
				load.getUsers().remove(userId-1);
				System.out.println("The user was removed!");
			}
			else{
				System.out.println("No users were removed.");
			}
				
		}
		
	}
	
	
	private int logIn(){
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
				return userId;
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
						return 0;
					}
					else{
						if(goBackToTheMainMenu() == true) mainMenu();
						else return 0;
					}		
		}
		return 0;	
		
	}
	
	private void addRating(){
		int userId = logIn();
		while(userId == 0)userId = logIn();
		//display all movies with the desired search term.
		searchForMovies();	
		System.out.print("Type in the movie ID you want to add a rating for: ");
		int movieId = (input.nextInt());	//10 if 10
		boolean correctInput = false;
		System.out.println("movieId : "+ movieId);
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
		
		System.out.print("Rate the movie "+ load.getItems().get(movieId-1).getMovieTitle()+" from -5 to 5: " );
		short userRating = input.nextShort();
		input.nextLine();
		//dividing by 1000L gets the unix time.
		long unixTime = System.currentTimeMillis() / 1000L;
		System.out.println("Do you want to give the movie "+ load.getItems().get(movieId-1).getMovieTitle()+" ("+load.getItems().get(movieId-1).getReleaseDate()+") a rating of "+userRating+"?(Y/N)");
		char userInput = input.nextLine().toUpperCase().charAt(0);
		while(!(Character.toString(userInput).matches("Y")) && !(Character.toString(userInput).matches("N"))){
			System.err.println("\n|      Invalid Input.     |\n|                  	  |\n|---Type in 'M' or 'F'!---|\n|                  	  |\n|       Press Enter.      |");
			input.nextLine();
			System.out.println("Do you want to give the movie "+ load.getItems().get(movieId-1).getMovieTitle()+" ("+load.getItems().get(movieId-1).getReleaseDate()+") a rating of "+userRating+"?(Y/N)");
			userInput = input.nextLine().toUpperCase().charAt(0);
		}
		if(Character.toString(userInput).matches("Y")){
			//add a new rating of the user definied parameters. MovieID+1 because indexing starts at 0 where Ids start from 1.
		load.getRatings().add(new Rating(String.valueOf(userId),String.valueOf(movieId),String.valueOf(userRating),String.valueOf(unixTime)));
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
