package netflixAutoplay;

/**
 * Console display only. This class does not store its own data structure.
 * It reads data from Show and ShowList.
 *
 * Algorithms:
 * - printSeriesMenu: walk the show array from start to end, O(n)
 * - autoPlay: check the next link, then move the pointer, O(1)
 */
public class ConsoleUI {

	public static void display(Show show) {
		if (show.getCurrentEpisode() == null) {
			return;
		}

		Episode episode = show.getCurrentEpisode();
		System.out.println("\n========================================");
		System.out.println("       NETFLIX - CONSOLE EDITION");
		System.out.println("========================================");
		System.out.println("[Now Playing] " + show.getShowTitle());
		System.out.println("> Season " + episode.getSeasonNumber() + " Episode " + episode.getEpisodeNumber()
				+ ": \"" + episode.getTitle() + "\" (Duration: " + episode.getDuration() + " mins)");
		System.out.println("----------------------------------------");
		System.out.println("[Status]: Playing... [ 00:45 / " + episode.getDuration() + ":00 ]");
		System.out.println("\nMenu:");
		System.out.println("1. Play Next Episode (>> Next)");
		System.out.println("2. Play Previous Episode (<< Prev)");
		System.out.println("3. Select Specific Episode");
		System.out.println("4. Change Series (Switch Show)");
		System.out.println("5. [Simulate] Finish Episode (Trigger Auto-play)");
		System.out.println("6. Exit");
		System.out.println("----------------------------------------");
		System.out.print("Enter your choice: ");
	}

	public static void printPlayNextResult(boolean moved, Episode episode) {
		if (moved) {
			System.out.println("\n>> [System] Playing the next episode: S" + episode.getSeasonNumber() + " EP"
					+ episode.getEpisodeNumber());
		} else {
			System.out.println("\n>> [System] Notice: This is the last episode of the series! (End of List)");
		}
	}

	public static void printPlayPreviousResult(boolean moved, Episode episode) {
		if (moved) {
			System.out.println("\n>> [System] Going back to the previous episode: S" + episode.getSeasonNumber()
					+ " EP" + episode.getEpisodeNumber());
		} else {
			System.out.println("\n>> [System] Notice: This is the first episode; cannot go back any further!");
		}
	}

	public static void printSelectResult(boolean found, int seasonNum, int epNum) {
		if (found) {
			System.out.println("\n>> [System] Successfully selected S" + seasonNum + " EP" + epNum);
		} else {
			System.out.println("\n>> [System] Error: S" + seasonNum + " EP" + epNum + " was not found");
		}
	}

	public static void printSeriesMenu(ShowList allShows) {
		System.out.println("\n--- Select a Series ---");
		for (int i = 0; i < allShows.size(); i++) {
			Show show = allShows.get(i);
			System.out.println((i + 1) + ". " + show.getShowTitle() + " (" + show.getEpisodeCount()
					+ " Episodes total)");
		}
		System.out.print("Choose series to watch: ");
	}

	public static void printChangedShow(String title) {
		System.out.println("\n>> [System] Changed to: " + title);
	}

	public static void printSeriesNotFound() {
		System.out.println("\n>> [System] The selected series was not found.");
	}

	public static void printInvalidNumber() {
		System.out.println("\n>> [System] Please enter a valid number.");
	}

	public static void printInvalidChoice() {
		System.out.println("\n>> [System] Invalid choice! Please try again.");
	}

	public static void printExit() {
		System.out.println("\n>> [System] Exiting Netflix... Goodbye!");
	}

	public static void autoPlay(Show show) {
		if (show.hasNextEpisode()) {
			Episode episode = show.getCurrentEpisode();
			System.out.println("\n[Status]: S" + episode.getSeasonNumber() + " EP" + episode.getEpisodeNumber()
					+ " Finished.");

			for (int i = 5; i > 0; i--) {
				System.out.println("Auto-playing next episode in " + i + "s...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			printPlayNextResult(show.playNextEpisode(), show.getCurrentEpisode());
		} else {
			System.out.println("\n[Status]: Episode Finished.");
			System.out.println(">> [System] Notice: This is the last episode of the series!");
		}
	}
}
