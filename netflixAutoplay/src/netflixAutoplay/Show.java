package netflixAutoplay;

public class Show {
	String showTitle;
	DoublyLinkedList episodeList;
	Episode currentEpisode;

	public Show(String showTitle) {
		this.showTitle = showTitle;
		this.episodeList = new DoublyLinkedList();
		this.currentEpisode = null;
	}

	// Include the season number.
	public void addEpisode(int seasonNumber, int episodeNumber, String title, int duration) {
		Episode newEp = new Episode(seasonNumber, episodeNumber, title, duration);
		episodeList.addEpisode(newEp);
		if (currentEpisode == null) {
			currentEpisode = newEp;
		}
	}

	public void playNextEpisode() {
		if (currentEpisode != null && currentEpisode.next != null) {
			currentEpisode = currentEpisode.next;
			System.out.println("\n>> [System] Playing the next episode: S" + currentEpisode.seasonNumber + " EP"
					+ currentEpisode.episodeNumber);
		} else {
			System.out.println("\n>> [System] Notice: This is the last episode of the series! (End of List)");
		}
	}

	public void playPreviousEpisode() {
		if (currentEpisode != null && currentEpisode.previous != null) {
			currentEpisode = currentEpisode.previous;
			System.out.println("\n>> [System] Going back to the previous episode: S" + currentEpisode.seasonNumber + " EP"
					+ currentEpisode.episodeNumber);
		} else {
			System.out.println("\n>> [System] Notice: This is the first episode; cannot go back any further!");
		}
	}

	// Find an episode by season and episode number.
	public void selectEpisode(int seasonNum, int epNum) {
		Episode temp = episodeList.head;
		while (temp != null) {
			if (temp.seasonNumber == seasonNum && temp.episodeNumber == epNum) {
				currentEpisode = temp;
				System.out.println("\n>> [System] Successfully selected S" + seasonNum + " EP" + epNum);
				return;
			}
			temp = temp.next;
		}
		System.out.println("\n>> [System] Error: S" + seasonNum + " EP" + epNum + " was not found");
	}
}
