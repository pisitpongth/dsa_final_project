package netflixAutoplay;

public class Episode {
	int seasonNumber; // เพิ่มซีซัน
	int episodeNumber;
	String title;
	int duration;
	Episode next;
	Episode previous;

	public Episode(int seasonNumber, int episodeNumber, String title, int duration) {
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
		this.title = title;
		this.duration = duration;
		this.next = null;
		this.previous = null;
	}
}