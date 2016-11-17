package app.wrapperClasses;

public class Rating {
	int userId;
	int itemId;
	short rating;
	long timestamp;

	public Rating(int userId, int itemId, short rating, long timestamp) {
		this.userId = userId;
		this.itemId = itemId;
		this.rating = rating;
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "\nRating [userId=" + userId + ", itemId=" + itemId + ", rating=" + rating + ", timestamp=" + timestamp
				+ "]";
	}

	
//Getters and Setters
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
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
