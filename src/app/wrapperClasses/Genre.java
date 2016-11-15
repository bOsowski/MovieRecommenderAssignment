package app.wrapperClasses;

public class Genre {

	
	private String genreName;
	private short genreId;

	public Genre(String genreName, short genreId) {

	this.genreName = genreName;
	this.genreId = genreId;
	}

	
	
	@Override
	public String toString() {
		return "\nGenre [genreName=" + genreName + ", genreId=" + genreId + "]";
	}



	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public short getGenreId() {
		return genreId;
	}

	public void setGenreId(short genreId) {
		this.genreId = genreId;
	}
	
	
	

}
