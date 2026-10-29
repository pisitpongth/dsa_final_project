package netflixAutoplay;

public class Episode {
	int episodeNumber;
	String title;
	int duration;
	Episode next;
	Episode previous;

	public Episode(int episodeNumber, String title, int duration) {
		this.episodeNumber = episodeNumber;
		this.title = title;
		this.duration = duration;
		this.next = null;
		this.previous = null;
	}
}