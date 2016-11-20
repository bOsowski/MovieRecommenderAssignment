package app.wrapperClasses;



public class Rating {
	int userId;
	int itemId;
	String movieTitle;
	short rating;
	long timestamp;

	public Rating(String userId, String itemId, String rating, String timestamp) {
		setUserId(userId);
		setItemId(itemId);
		setRating(rating);
		setTimestamp(timestamp);
		
		
	}
	


	
@Override
	public String toString() {
		return "\nRating [userId=" + userId + ", itemId=" + itemId + ", movieTitle=" + movieTitle + ", rating=" + rating
				+ ", timestamp=" + timestamp + "]";
	}




	//Getters and Setters
	public void setMovieTitle(String movieTitle){
		this.movieTitle = movieTitle;
	}
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		if(userId != null && !userId.isEmpty() && userId.matches("-?\\d+")){
			this.userId = Integer.parseInt(userId);
		}
		else this.userId = 0;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		if(itemId != null && !itemId.isEmpty() && itemId.matches("-?\\d+")){
			this.itemId = Integer.parseInt(itemId);
		}
		else this. itemId = 0;
	}


	public short getRating() {
		return rating;
	}


	public void setRating(String ratingString) {
		if(ratingString != null && !ratingString.isEmpty() && ratingString.matches("-?\\d+")){
			Short rating = Short.parseShort(ratingString);
			if(rating>=5){
				this.rating = 5;
			}
			else if(rating<=-5){
				this.rating = -5;
			}
			else if(rating >= -5 && rating <= 5){
				this.rating = rating;
			}
		}		
		else this.rating = 0;
	}


	public long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(String timestamp) {
		if(timestamp != null && !timestamp.isEmpty() && timestamp.matches("-?\\d+")){
		this.timestamp = Long.parseLong(timestamp);
		}
		else this.timestamp = 0;
	}
//End of Getters and Setters
}
