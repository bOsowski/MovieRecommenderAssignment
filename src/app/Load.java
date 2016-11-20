package app;
import java.io.File;
import java.util.ArrayList;

import app.wrapperClasses.Genre;
import app.wrapperClasses.Item;
import app.wrapperClasses.Occupation;
import app.wrapperClasses.Rating;
import app.wrapperClasses.User;
import edu.princeton.cs.introcs.In;

public class Load {
	
	ArrayList<User> users = new ArrayList<User>();	//arrayList holding users.
	ArrayList<Rating> ratings = new ArrayList<Rating>();	//arrayList holding ratings.
	ArrayList<Item> items = new ArrayList<Item>(); //arrayList holding items.
	
	ArrayList<Occupation> occupations = new ArrayList<Occupation>();
	ArrayList<Genre> genres = new ArrayList<Genre>();
	
	public Load(){
		readUsersFile("data_movieLens/users.dat");
	//	System.out.println(users);
	//	System.out.println("number of users: "+ users.size());
		readRatingsFile("data_movieLens/ratings.dat");
	//	System.out.println(ratings);
	//	System.out.println("number of ratings: "+ ratings.size());
		readItemsFile("data_movieLens/items.dat");
		addOverallRating();
	//	System.out.println(items);
	//	System.out.println("number of items: "+ items.size());
		//readOccupationsFile("data_movieLens/occupation.dat");
	//	System.out.println(occupations);
	//	System.out.println("number of occupations: "+ occupations.size());
		readGenresFile("data_movieLens/genre.dat");
	//	System.out.println(genres);
	//	System.out.println("number of genres: "+ genres.size());
		
	}
	public void addOverallRating(){
	for(int i = 0; i<ratings.size(); i++){
		//for each rating in the list, assign the rating's movieID the desired overall rating.
		
		int ratingsMovieId = ratings.get(i).getItemId()-1;
		double rating = ratings.get(i).getRating();
		items.get(ratingsMovieId).setOverallRating(rating);
		
	}
	}
	
	
	
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public ArrayList<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public ArrayList<Occupation> getOccupations() {
		return occupations;
	}
	public void setOccupations(ArrayList<Occupation> occupations) {
		this.occupations = occupations;
	}
	public ArrayList<Genre> getGenres() {
		return genres;
	}
	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}




	//reads the users file and wraps each user in the User class and adds each instance to the users arraylist.
	public void readUsersFile(String fileName){
	
		  File usersFile = new File(fileName);
	      In inUsers = new In(usersFile);
	        //each field is separated(delimited) by a '|'
	      String delims = "[|]";
	      while (!inUsers.isEmpty()) {
	          // get user and rating from data source
	          String userDetails = inUsers.readLine();

	          // parse user details string
	          String[] userTokens = userDetails.split(delims);

	          // output user data to console.
	          if (userTokens.length == 7) {     	  
	        	  users.add(new User(Integer.parseInt(userTokens[0]),userTokens[1],userTokens[2],Integer.parseInt(userTokens[3]),userTokens[4].charAt(0),userTokens[5],userTokens[6]));
	          }else
	          {
	              try {
					throw new Exception("Invalid member length: "+userTokens.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	      }
	}
	
	//reads the ratings file and wraps each user in the Rating class and adds each instance to the ratings arraylist.
	public void readRatingsFile(String fileName){
		
		  File ratingsFile = new File(fileName);
	      In inRatings = new In(ratingsFile);
	        //each field is separated(delimited) by a '|'
	      String delims = "[|]";
	      while (!inRatings.isEmpty()) {
	          // get user and rating from data source
	          String ratingDetails = inRatings.readLine();

	          // parse user details string
	          String[] ratingTokens = ratingDetails.split(delims);

	          // output user data to console.
	          if (ratingTokens.length == 4) {     	  
	        	ratings.add(new Rating(ratingTokens[0],ratingTokens[1],ratingTokens[2],ratingTokens[3]));  
	          }else
	          {
	              try {
					throw new Exception("Invalid member length: "+ratingTokens.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	      }
	}
	
	//reads the items file and wraps each user in the Item class and adds each instance to the items arraylist.
	public void readItemsFile(String fileName){	
		
		  File itemsFile = new File(fileName);
	      In inItems = new In(itemsFile);
	        //each field is separated(delimited) by a '|'
	      String delims = "[|]";
	      while (!inItems.isEmpty()) {
	          // get user and rating from data source
	          String itemDetails = inItems.readLine();

	          // parse user details string
	          String[] itemTokens = itemDetails.split(delims);
	         // if(itemTokens[0] == null || itemTokens[1] == null || itemTokens[2] == null || itemTokens[3] == null || itemTokens[4] == null || itemTokens[5] == null || itemTokens[6] == null || itemTokens[7] == null || itemTokens[8] == null || itemTokens[9] == null || itemTokens[10] == null || itemTokens[11] == null || itemTokens[12] == null || itemTokens[13] == null || itemTokens[14] == null || itemTokens[15] == null || itemTokens[16] == null || itemTokens[17] == null || itemTokens[18] == null || itemTokens[19] == null || itemTokens[20] == null || itemTokens[21] == null || itemTokens[22] == null)
	         // {
	          // output user data to console.
	          if (itemTokens.length == 23) {   
	        	  String[] titleAndDate = itemTokens[1].split(" ");	//make an array of stings of each word split by a 'space'.
	        	  String vidUnformattedDate = titleAndDate[titleAndDate.length-1];	//take the last word from title, which is the date in the following format: (date).
	        	  String vidTitle = itemTokens[1].substring(0, itemTokens[1].length()-vidUnformattedDate.length());	//take the date away from the title of the movie.
	        	  String formattedVidDate = vidUnformattedDate.substring(1, vidUnformattedDate.length()-1);	//remove the brackets which the date is inside of.
	        	  int vidDate;
	        	  if(formattedVidDate.matches("-?\\d+")){
	        	  vidDate = Integer.parseInt(formattedVidDate);	//parse the formattedVidDate String into an int.
	        	  }
	        	  else vidDate = 0;
	        	  
	        	  String vidReleaseDate;
	        	  if(itemTokens[2].contains("-")){
	        	  vidReleaseDate = itemTokens[2];
	        	  }
	        	  else vidReleaseDate = "00-Jan-0000";
	        	  
	        	  items.add(new Item(itemTokens[0], vidTitle, String.valueOf(vidDate), vidReleaseDate,itemTokens[3],Short.parseShort(itemTokens[4]),Short.parseShort(itemTokens[5]),Short.parseShort(itemTokens[6]),Short.parseShort(itemTokens[7]),Short.parseShort(itemTokens[8]),Short.parseShort(itemTokens[9]),Short.parseShort(itemTokens[10]),Short.parseShort(itemTokens[11]),Short.parseShort(itemTokens[12]),Short.parseShort(itemTokens[13]),Short.parseShort(itemTokens[14]),Short.parseShort(itemTokens[15]),Short.parseShort(itemTokens[16]),Short.parseShort(itemTokens[17]),Short.parseShort(itemTokens[18]),Short.parseShort(itemTokens[19]),Short.parseShort(itemTokens[20]),Short.parseShort(itemTokens[21]),Short.parseShort(itemTokens[22])));  
	        	  
	          }
	          else{
	              try {
					throw new Exception("Invalid member length: "+itemTokens.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	         // }
	        //  else{
	        //	 items.add(new Item(0,"a",0,"a", "a",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0));
	         // }
	          }
	      
	}
	
	
	
	public void readOccupationsFile(String fileName){
		
		  File occupationsFile = new File(fileName);
	      In inOccupations = new In(occupationsFile);
	      while (!inOccupations.isEmpty()) {
	          // get user and rating from data source
	          String occupationDetails = inOccupations.readLine();
	          
	        	occupations.add(new Occupation(occupationDetails));  
				}
	}
	
	
	
	public void readGenresFile(String fileName){
		
		  File genresFile = new File(fileName);
	      In inGenres = new In(genresFile);
	        //each field is separated(delimited) by a '|'
	      String delims = "[|]";
	      while (!inGenres.isEmpty()) {
	          // get user and rating from data source
	          String genreDetails = inGenres.readLine();

	          // parse user details string
	          String[] genreTokens = genreDetails.split(delims);

	          // output user data to console.
	          if (genreTokens.length == 2) {     	  
	        	  genres.add(new Genre(genreTokens[0],Short.parseShort(genreTokens[1])));
	          }else
	          {
	              try {
					throw new Exception("Invalid member length: "+genreTokens.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          }
	      }
	}
	
	

      
	
}
