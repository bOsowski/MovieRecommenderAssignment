package app.wrapperClasses;

import java.text.DecimalFormat;


public class Item{
	
	private int movieId;
	private String movieTitle;
	private int releaseDate;
	//private String videoReleaseDate;
	
	private short videoReleaseDate_Day;
	private short videoReleaseDate_Month;
	private short videoReleaseDate_Year;
	
	private String movieUrl;
	
	private short unknownGenre;
	private short actionGenre;
	private short adventureGenre;
	private short animationGenre;
	private short childrensGenre;
	private short comedyGenre;
	private short crimeGenre;
	private short documentaryGenre;
	private short dramaGenre;
	private short fantasyGenre;
	private short film_noirGenre;
	private short horrorGenre;
	private short musicalGenre;
	private short mysteryGenre;
	private short romanceGenre;
	private short sci_fiGenre;
	private short thrillerGenre;
	private short warGenre;
	private short westernGenre;
	
	private String genres = "";
	
	private double overallRating = 0;
	private int amountOfRatings = 0;

	public Item(String movieId, String movieTitle, String releaseDate, String videoReleaseDate, String movieUrl,
			short unknownGenre,
			short actionGenre, short adventureGenre, short animationGenre, short childrensGenre,
			short comedyGenre, short crimeGenre, short documentaryGenre, short dramaGenre,
			short fantasyGenre, short film_noirGenre, short horrorGenre, short musicalGenre,
			short mysteryGenre, short romanceGenre, short sci_fiGenre, short thrillerGenre,
			short warGenre, short westernGenre) {
		
		setMovieId(movieId);
		setMovieTitle(movieTitle);
		setReleaseDate(releaseDate);
		setMovieUrl(movieUrl);
		
		//this.videoReleaseDate = videoReleaseDate;
		//take the videoReleaseDate and parse it into three different variables day,month,year.
		if(videoReleaseDate.contains("-")){
			
		
		String[] vidReleaseDate = videoReleaseDate.split("-");
		
		if(vidReleaseDate[1].equalsIgnoreCase("Jan")){
			vidReleaseDate[1] = "01";
		}
		else if(vidReleaseDate[1].equalsIgnoreCase("Feb")){
			vidReleaseDate[1] = "02";
		}
		else if(vidReleaseDate[1].equalsIgnoreCase("Mar")){
			vidReleaseDate[1] = "03";
		}
		else if(vidReleaseDate[1].equalsIgnoreCase("Apr")){
			vidReleaseDate[1] = "04";
		}
		else if(vidReleaseDate[1].equalsIgnoreCase("May")){
			vidReleaseDate[1] = "05";
		}
		else if(vidReleaseDate[1].equalsIgnoreCase("Jun")){
			vidReleaseDate[1] = "06";
		}
		else if(vidReleaseDate[1].equalsIgnoreCase("Jul")){
			vidReleaseDate[1] = "07";
		}
		else if(vidReleaseDate[1].equalsIgnoreCase("Aug")){
			vidReleaseDate[1] = "08";
		}
		else if(vidReleaseDate[1].equalsIgnoreCase("Sep")){
			vidReleaseDate[1] = "09";
		}
		else if(vidReleaseDate[1].equalsIgnoreCase("Oct")){
			vidReleaseDate[1] = "10";
		}
		else if(vidReleaseDate[1].equalsIgnoreCase("Nov")){
			vidReleaseDate[1] = "11";
		}
		else if(vidReleaseDate[1].equalsIgnoreCase("Dec")){
			vidReleaseDate[1] = "12";
		}
		
		this.videoReleaseDate_Day = Short.parseShort(vidReleaseDate[0]);
		this.videoReleaseDate_Month = Short.parseShort(vidReleaseDate[1]);
		this.videoReleaseDate_Year = Short.parseShort(vidReleaseDate[2]);
		}
		
		this.unknownGenre = unknownGenre;
		this.actionGenre = actionGenre;
		this.adventureGenre = adventureGenre;
		this.animationGenre = animationGenre;
		this.childrensGenre = childrensGenre;
		this.comedyGenre = comedyGenre;
		this.crimeGenre = crimeGenre;
		this.documentaryGenre = documentaryGenre;
		this.dramaGenre = dramaGenre;
		this.fantasyGenre = fantasyGenre;
		this.film_noirGenre = film_noirGenre;
		this.horrorGenre = horrorGenre;
		this.musicalGenre = musicalGenre;
		this.mysteryGenre = mysteryGenre;
		this.romanceGenre = romanceGenre;
		this.sci_fiGenre = sci_fiGenre;
		this.thrillerGenre = thrillerGenre;
		this.warGenre = warGenre;
		this.westernGenre = westernGenre;
		addGenres();
	}
	
	public String getGenres(){
		return this.genres;
	}
	
	public void addGenres(){
		if(unknownGenre == 1){
			this.genres = genres+" unknown ";
		}		
		if(actionGenre == 1){
			this.genres = genres+" action ";
		}		
		if(adventureGenre  == 1){
			this.genres = genres+" adventure ";
		}		
		if(animationGenre == 1){
			this.genres = genres+" animation ";
		}		
		if(childrensGenre == 1){
			this.genres = genres+" childrens ";
		}	
		if(comedyGenre == 1){
			this.genres = genres+" comedy ";
		}	
		if(crimeGenre == 1){
			this.genres = genres+" crime ";
		}	
		if(documentaryGenre == 1){
			this.genres = genres+" documentary ";
		}
		if(dramaGenre == 1){
			this.genres = genres+" drama ";
		}
		if(fantasyGenre == 1){
			this.genres = genres+" fantasy ";
		}
		if(film_noirGenre == 1){
			this.genres = genres+" film noir ";
		}	
		if(horrorGenre == 1){
			this.genres = genres+" horror ";
		}
		if(musicalGenre == 1){
			this.genres = genres+" musical ";
		}
		if(mysteryGenre == 1){
			this.genres = genres+" mystery ";
		}
		if(romanceGenre == 1){
			this.genres = genres+" romance ";
		}
		if(sci_fiGenre == 1){
			this.genres = genres+" sci fi ";
		}
		if(thrillerGenre == 1){
			this.genres = genres+" thriller ";
		}
		if(warGenre == 1){
			this.genres = genres+" war ";
		}
		if(westernGenre == 1){
			this.genres = genres+" western ";
		}
	}
	
	@Override
	public String toString(){
		
		String details = ("\nItem [movieId=" + movieId + ", movieTitle=" + movieTitle + ", releaseDate=" + releaseDate
			  + " Overall Rating: "+ (new DecimalFormat("##.#").format((overallRating/amountOfRatings))) +" Amount of Ratings: "+amountOfRatings +", movieUrl=" + movieUrl);
		
		if(unknownGenre == 1){
			details = details + (", unknownGenre");
		}		
		if(actionGenre == 1){
			details = details + (", actionGenre");
		}		
		if(adventureGenre  == 1){
			details = details + (", adventureGenre");
		}		
		if(animationGenre == 1){
			details = details + (", animationGenre");
		}		
		if(childrensGenre == 1){
			details = details + (", childrensGenre");
		}	
		if(comedyGenre == 1){
			details = details + (", comedyGenre");
		}	
		if(crimeGenre == 1){
			details = details + (", crimeGenre");
		}	
		if(documentaryGenre == 1){
			details = details + (", documentaryGenre");
		}
		if(dramaGenre == 1){
			details = details + (", dramaGenre");
		}
		if(fantasyGenre == 1){
			details = details + (", fantasyGenre");
		}
		if(film_noirGenre == 1){
			details = details + (", film_noirGenre");
		}	
		if(horrorGenre == 1){
			details = details + (", horrorGenre");
		}
		if(musicalGenre == 1){
			details = details + (", musicalGenre");
		}
		if(mysteryGenre == 1){
			details = details + (", mysteryGenre");
		}
		if(romanceGenre == 1){
			details = details + (", romanceGenre");
		}
		if(sci_fiGenre == 1){
			details = details + (", sci_fiGenre");
		}
		if(thrillerGenre == 1){
			details = details + (", thrillerGenre");
		}
		if(warGenre == 1){
			details = details + (", warGenre");
		}
		if(westernGenre == 1){
			details = details + (", westernGenre");
		}
		
		details = details + ("]");

		return details;
	}

	public int compareToDate(Item that)
	{
		if (this.releaseDate < that.getReleaseDate()) return +1;
		if (this.releaseDate > that.getReleaseDate()) return -1;
		return 0;
	}
	
	public int compareToRating(Item that) {
		if (getOverallRating() < that.getOverallRating()) return +1;
		if (getOverallRating() > that.getOverallRating()) return -1;
		return 0;
	}
	
	public int compareToPopularity(Item that) {
		if (getAmountOfRatings() < that.getAmountOfRatings()) return +1;
		if (getAmountOfRatings() > that.getAmountOfRatings()) return -1;
		return 0;
	}
	
	public int getAmountOfRatings(){
		return this.amountOfRatings;
	}
	
	public void setOverallRating(double overallRating){
		amountOfRatings++;
		this.overallRating = this.overallRating + overallRating;
	}
	
	public double getOverallRating(){
		return this.overallRating/this.amountOfRatings;
	}
	
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		if(movieId.matches("-?\\d+")){
		this.movieId = Integer.parseInt(movieId);
		}
		else this.movieId = 0;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		if(movieTitle != null && !movieTitle.isEmpty()){
		this.movieTitle = movieTitle;
		}
		else this.movieTitle = "unknown";
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		if(releaseDate.length()==4 && releaseDate.matches("-?\\d+") ){
		this.releaseDate = Integer.parseInt(releaseDate);
		}
	}

	public short getVideoReleaseDate_Day() {
		return videoReleaseDate_Day;
	}

	public void setVideoReleaseDate_Day(short videoReleaseDate_Day) {
		this.videoReleaseDate_Day = videoReleaseDate_Day;
	}

	public short getVideoReleaseDate_Month() {
		return videoReleaseDate_Month;
	}

	public void setVideoReleaseDate_Month(short videoReleaseDate_Month) {
		this.videoReleaseDate_Month = videoReleaseDate_Month;
	}

	public short getVideoReleaseDate_Year() {
		return videoReleaseDate_Year;
	}

	public void setVideoReleaseDate_Year(short videoReleaseDate_Year) {
		this.videoReleaseDate_Year = videoReleaseDate_Year;
	}

	public String getMovieUrl() {
		return movieUrl;
	}

	public void setMovieUrl(String movieUrl) {
		if(movieUrl.contains("http") || movieUrl.contains(".")){
		this.movieUrl = movieUrl;
		}
		else this.movieUrl = "unknown";
	}

	public short getUnknownGenre() {
		return unknownGenre;
	}

	public void setUnknownGenre(short unknownGenre) {
		this.unknownGenre = unknownGenre;
	}

	public short getActionGenre() {
		return actionGenre;
	}

	public void setActionGenre(short actionGenre) {
		this.actionGenre = actionGenre;
	}

	public short getAdventureGenre() {
		return adventureGenre;
	}

	public void setAdventureGenre(short adventureGenre) {
		this.adventureGenre = adventureGenre;
	}

	public short getAnimationGenre() {
		return animationGenre;
	}

	public void setAnimationGenre(short animationGenre) {
		this.animationGenre = animationGenre;
	}

	public short getChildrensGenre() {
		return childrensGenre;
	}

	public void setChildrensGenre(short childrensGenre) {
		this.childrensGenre = childrensGenre;
	}

	public short getComedyGenre() {
		return comedyGenre;
	}

	public void setComedyGenre(short comedyGenre) {
		this.comedyGenre = comedyGenre;
	}

	public short getCrimeGenre() {
		return crimeGenre;
	}

	public void setCrimeGenre(short crimeGenre) {
		this.crimeGenre = crimeGenre;
	}

	public short getDocumentaryGenre() {
		return documentaryGenre;
	}

	public void setDocumentaryGenre(short documentaryGenre) {
		this.documentaryGenre = documentaryGenre;
	}

	public short getDramaGenre() {
		return dramaGenre;
	}

	public void setDramaGenre(short dramaGenre) {
		this.dramaGenre = dramaGenre;
	}

	public short getFantasyGenre() {
		return fantasyGenre;
	}

	public void setFantasyGenre(short fantasyGenre) {
		this.fantasyGenre = fantasyGenre;
	}

	public short getFilm_noirGenre() {
		return film_noirGenre;
	}

	public void setFilm_noirGenre(short film_noirGenre) {
		this.film_noirGenre = film_noirGenre;
	}

	public short getHorrorGenre() {
		return horrorGenre;
	}

	public void setHorrorGenre(short horrorGenre) {
		this.horrorGenre = horrorGenre;
	}

	public short getMusicalGenre() {
		return musicalGenre;
	}

	public void setMusicalGenre(short musicalGenre) {
		this.musicalGenre = musicalGenre;
	}

	public short getMysteryGenre() {
		return mysteryGenre;
	}

	public void setMysteryGenre(short mysteryGenre) {
		this.mysteryGenre = mysteryGenre;
	}

	public short getRomanceGenre() {
		return romanceGenre;
	}

	public void setRomanceGenre(short romanceGenre) {
		this.romanceGenre = romanceGenre;
	}

	public short getSci_fiGenre() {
		return sci_fiGenre;
	}

	public void setSci_fiGenre(short sci_fiGenre) {
		this.sci_fiGenre = sci_fiGenre;
	}

	public short getThrillerGenre() {
		return thrillerGenre;
	}

	public void setThrillerGenre(short thrillerGenre) {
		this.thrillerGenre = thrillerGenre;
	}

	public short getWarGenre() {
		return warGenre;
	}

	public void setWarGenre(short warGenre) {
		this.warGenre = warGenre;
	}

	public short getWesternGenre() {
		return westernGenre;
	}

	public void setWesternGenre(short westernGenre) {
		this.westernGenre = westernGenre;
	}





	
	
	

}
