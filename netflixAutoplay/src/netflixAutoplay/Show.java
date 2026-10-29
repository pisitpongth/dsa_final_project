package netflixAutoplay;

public class Show {
	String showTitle;
	Episode head;
	Episode currnetEpisode;

	public Show(String showTitle, Episode head, Episode currentEpisode) {
		this.showTitle = showTitle;
		this.head = head;
		this.currnetEpisode = currentEpisode;
	}
}
