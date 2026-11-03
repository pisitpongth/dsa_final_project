package netflixAutoplay;

/**
 * Data structure: Doubly Linked List of episodes for one show.
 * currentEpisode points to the episode that is playing now.
 *
 * Algorithms:
 * - addEpisode: add at the end of the list, O(1)
 * - playNext / playPrevious: move the pointer to next or previous, O(1)
 * - selectEpisode: linear search for a season and episode number, O(n)
 * - getEpisodeCount: walk the list and count, O(n)
 */
public class Show {
	private String showTitle;
	private DoublyLinkedList episodeList;
	private Episode currentEpisode;

	public Show(String showTitle) {
		this.showTitle = showTitle;
		this.episodeList = new DoublyLinkedList();
		this.currentEpisode = null;
	}

	public String getShowTitle() {
		return showTitle;
	}

	public Episode getCurrentEpisode() {
		return currentEpisode;
	}

	public int getEpisodeCount() {
		return episodeList.size();
	}

	public boolean hasNextEpisode() {
		return currentEpisode != null && currentEpisode.getNext() != null;
	}

	public void addEpisode(int seasonNumber, int episodeNumber, String title, int duration) {
		Episode newEp = new Episode(seasonNumber, episodeNumber, title, duration);
		episodeList.addEpisode(newEp);
		if (currentEpisode == null) {
			currentEpisode = newEp;
		}
	}

	// Move to the next episode using the next link. No full-list search.
	public boolean playNextEpisode() {
		if (hasNextEpisode()) {
			currentEpisode = currentEpisode.getNext();
			return true;
		}
		return false;
	}

	// Move back using the previous link.
	public boolean playPreviousEpisode() {
		if (currentEpisode != null && currentEpisode.getPrevious() != null) {
			currentEpisode = currentEpisode.getPrevious();
			return true;
		}
		return false;
	}

	// Linear search: find the episode by season number and episode number.
	public boolean selectEpisode(int seasonNum, int epNum) {
		Episode found = episodeList.find(seasonNum, epNum);
		if (found != null) {
			currentEpisode = found;
			return true;
		}
		return false;
	}
}
