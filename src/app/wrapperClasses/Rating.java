package app.wrapperClasses;

public class Rating {
	int movieId;
	int itemId;
	short rating;
	long timestamp;

	public Rating(int movieId, int itemId, short rating, long timestamp) {
		this.movieId = movieId;
		this.itemId = itemId;
		this.rating = rating;
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "\nRating [movieId=" + movieId + ", itemId=" + itemId + ", rating=" + rating + ", timestamp=" + timestamp
				+ "]";
	}

	
//Getters and Setters
	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public short getRating() {
		return rating;
	}


	public void setRating(short rating) {
		this.rating = rating;
	}


	public long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
//End of Getters and Setters
}
