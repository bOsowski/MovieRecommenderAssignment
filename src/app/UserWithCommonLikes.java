package app;

public class UserWithCommonLikes {
	
	int userId;
	String favouriteMovies = "";
	
	
	public UserWithCommonLikes(int userId, String favouriteMovies){
		this.userId = userId;
		addFavouriteMovies(favouriteMovies);
	}
	
	public void addFavouriteMovies(String favouriteMovies){
		this.favouriteMovies = this.favouriteMovies+ " " + favouriteMovies;
	}
	
	public String getFavouriteMovies(){
		return this.favouriteMovies;
	}
	
	public int getUserId(){
		return this.userId;
	}

}
