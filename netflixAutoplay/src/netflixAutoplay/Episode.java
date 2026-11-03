package netflixAutoplay;

/**
 * Data structure: a node in a Doubly Linked List.
 * Each node stores one episode and points to the previous and next episode.
 * This class has no algorithm. It only holds data.
 */
public class Episode {
	private int seasonNumber;
	private int episodeNumber;
	private String title;
	private int duration;
	private Episode next; // link to the next episode
	private Episode previous; // link to the previous episode

	public Episode(int seasonNumber, int episodeNumber, String title, int duration) {
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
		this.title = title;
		this.duration = duration;
		this.next = null;
		this.previous = null;
	}

	public int getSeasonNumber() {
		return seasonNumber;
	}

	public int getEpisodeNumber() {
		return episodeNumber;
	}

	public String getTitle() {
		return title;
	}

	public int getDuration() {
		return duration;
	}

	public Episode getNext() {
		return next;
	}

	public Episode getPrevious() {
		return previous;
	}

	void setNext(Episode next) {
		this.next = next;
	}

	void setPrevious(Episode previous) {
		this.previous = previous;
	}
}
