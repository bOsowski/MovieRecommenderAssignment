package app.wrapperClasses;

public class Item {
	
	private int movieId;
	private String movieTitle;
	private int releaseDate;
	private String videoReleaseDate;
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

	public Item(int movieId, String movieTitle, int releaseDate, String videoReleaseDate, String movieUrl, short unknownGenre,
			short actionGenre, short adventureGenre, short animationGenre, short childrensGenre,
			short comedyGenre, short crimeGenre, short documentaryGenre, short dramaGenre,
			short fantasyGenre, short film_noirGenre, short horrorGenre, short musicalGenre,
			short mysteryGenre, short romanceGenre, short sci_fiGenre, short thrillerGenre,
			short warGenre, short westernGenre) {
		
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.releaseDate = releaseDate;
		this.videoReleaseDate = videoReleaseDate;
		this.movieUrl = movieUrl;
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
	}

	public String toString1() {
		return "Item [movieId=" + movieId + ", movieTitle=" + movieTitle + ", releaseDate=" + releaseDate
				+ ", videoReleaseDate=" + videoReleaseDate + ", movieUrl=" + movieUrl
				
				+ ", unknownGenre=" + unknownGenre
				+ ", actionGenre=" + actionGenre 
				+ ", adventureGenre=" + adventureGenre 
				+ ", animationGenre=" + animationGenre 
				+ ", childrensGenre=" + childrensGenre 
				+ ", comedyGenre=" + comedyGenre
				+ ", crimeGenre=" + crimeGenre 
				+ ", documentaryGenre=" + documentaryGenre 
				+ ", dramaGenre=" + dramaGenre
				+ ", fantasyGenre=" + fantasyGenre 
				+ ", film_noirGenre=" + film_noirGenre 
				+ ", horrorGenre="+ horrorGenre 
				+ ", musicalGenre=" + musicalGenre 
				+ ", mysteryGenre=" + mysteryGenre 
				+ ", romanceGenre="+ romanceGenre 
				+ ", sci_fiGenre=" + sci_fiGenre 
				+ ", thrillerGenre=" + thrillerGenre 
				+ ", warGenre="+ warGenre 
				+ ", westernGenre=" + westernGenre 
				+ "]";
	}
	
	@Override
	public String toString(){
		
		String details = ("\nItem [movieId=" + movieId + ", movieTitle=" + movieTitle + ", releaseDate=" + releaseDate
				+ ", videoReleaseDate=" + videoReleaseDate + ", movieUrl=" + movieUrl);
		
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
			details = details + (", deocumentaryGenre");
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
	
	

}
