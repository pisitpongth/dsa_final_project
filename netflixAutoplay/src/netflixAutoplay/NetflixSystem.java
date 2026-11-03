package netflixAutoplay;

import java.util.Scanner;

/**
 * Main program and menu. This class does not build a data structure by itself.
 * It uses ShowList (dynamic array) for all shows.
 * Each Show uses a Doubly Linked List for its episodes.
 *
 * Algorithms:
 * - Menu 1 / 2: move the next or previous pointer, O(1)
 * - Menu 3: linear search for an episode, O(n)
 * - Menu 4: get a show from the array by index, O(1)
 * - Menu 5: check the next link, then play the next episode, O(1)
 */
public class NetflixSystem {

	public static void main(String[] args) {
		ShowList allShows = Catalog.loadShows();
		Scanner scanner = new Scanner(System.in);
		Show currentShow = allShows.get(0);
		boolean isRunning = true;

		while (isRunning) {
			ConsoleUI.display(currentShow);
			String choice = scanner.nextLine();

			switch (choice) {
			case "1":
				ConsoleUI.printPlayNextResult(currentShow.playNextEpisode(), currentShow.getCurrentEpisode());
				break;
			case "2":
				ConsoleUI.printPlayPreviousResult(currentShow.playPreviousEpisode(), currentShow.getCurrentEpisode());
				break;
			case "3":
				selectEpisode(scanner, currentShow);
				break;
			case "4":
				currentShow = changeShow(scanner, allShows, currentShow);
				break;
			case "5":
				ConsoleUI.autoPlay(currentShow);
				break;
			case "6":
				ConsoleUI.printExit();
				isRunning = false;
				break;
			default:
				ConsoleUI.printInvalidChoice();
			}
		}
		scanner.close();
	}

	private static void selectEpisode(Scanner scanner, Show currentShow) {
		Integer seasonNum = readInt(scanner, "Enter Season Number: ");
		if (seasonNum == null) {
			return;
		}
		Integer episodeNum = readInt(scanner, "Enter Episode Number: ");
		if (episodeNum == null) {
			return;
		}
		ConsoleUI.printSelectResult(currentShow.selectEpisode(seasonNum, episodeNum), seasonNum, episodeNum);
	}

	private static Show changeShow(Scanner scanner, ShowList allShows, Show currentShow) {
		ConsoleUI.printSeriesMenu(allShows);
		Integer showIndex = readInt(scanner, null);
		if (showIndex == null) {
			return currentShow;
		}

		showIndex = showIndex - 1;
		if (showIndex >= 0 && showIndex < allShows.size()) {
			Show selected = allShows.get(showIndex);
			ConsoleUI.printChangedShow(selected.getShowTitle());
			return selected;
		}

		ConsoleUI.printSeriesNotFound();
		return currentShow;
	}

	private static Integer readInt(Scanner scanner, String prompt) {
		if (prompt != null) {
			System.out.print(prompt);
		}
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			ConsoleUI.printInvalidNumber();
			return null;
		}
	}
}
