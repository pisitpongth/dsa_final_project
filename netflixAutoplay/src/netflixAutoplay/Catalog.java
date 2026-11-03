package netflixAutoplay;

/**
 * Starting data for the program. This is not a new data structure.
 * It uses ShowList (dynamic array) to store shows.
 * Each show uses a Doubly Linked List to store episodes.
 *
 * Algorithm: add shows and episodes one by one, O(1) for each add.
 */
public class Catalog {

	public static ShowList loadShows() {
		ShowList allShows = new ShowList();
		allShows.add(createStrangerThings());
		allShows.add(createInvincible());
		return allShows;
	}

	private static Show createStrangerThings() {
		Show strangerThings = new Show("Stranger Things");
		strangerThings.addEpisode(1, 1, "The Vanishing of Will Byers", 49);
		strangerThings.addEpisode(1, 2, "The Weirdo on Maple Street", 52);
		strangerThings.addEpisode(1, 3, "Holly, Jolly", 51);
		strangerThings.addEpisode(1, 4, "The Body", 50);
		strangerThings.addEpisode(1, 5, "The Flea and the Acrobat", 53);
		strangerThings.addEpisode(1, 6, "The Monster", 46);
		strangerThings.addEpisode(1, 7, "The Bathtub", 42);
		strangerThings.addEpisode(1, 8, "The Upside Down", 54);
		strangerThings.addEpisode(2, 1, "MADMAX", 48);
		strangerThings.addEpisode(2, 2, "Trick or Treat, Freak", 56);
		strangerThings.addEpisode(2, 3, "The Pollywog", 51);
		strangerThings.addEpisode(2, 4, "Will the Wise", 46);
		strangerThings.addEpisode(2, 5, "Dig Dug", 58);
		strangerThings.addEpisode(2, 6, "The Spy", 51);
		strangerThings.addEpisode(2, 7, "The Lost Sister", 45);
		strangerThings.addEpisode(2, 8, "The Mind Flayer", 47);
		strangerThings.addEpisode(2, 9, "The Gate", 62);
		strangerThings.addEpisode(3, 1, "Suzie, Do You Copy?", 51);
		strangerThings.addEpisode(3, 2, "The Mall Rats", 50);
		strangerThings.addEpisode(3, 3, "The Case of the Missing Lifeguard", 50);
		strangerThings.addEpisode(3, 4, "The Sauna Test", 53);
		strangerThings.addEpisode(3, 5, "The Flayed", 52);
		strangerThings.addEpisode(3, 6, "E Pluribus Unum", 60);
		strangerThings.addEpisode(3, 7, "The Bite", 55);
		strangerThings.addEpisode(3, 8, "The Battle of Starcourt", 78);
		return strangerThings;
	}

	private static Show createInvincible() {
		Show invincible = new Show("Invincible");
		invincible.addEpisode(1, 1, "It's About Time", 43);
		invincible.addEpisode(1, 2, "Here Goes Nothing", 44);
		invincible.addEpisode(1, 3, "Who You Calling Ugly?", 43);
		invincible.addEpisode(1, 4, "Neil Armstrong, Eat Your Heart Out", 45);
		invincible.addEpisode(1, 5, "That Actually Hurt", 42);
		invincible.addEpisode(1, 6, "You Look Kinda Dead", 44);
		invincible.addEpisode(1, 7, "We Need to Talk", 46);
		invincible.addEpisode(1, 8, "Where I Really Come From", 48);
		invincible.addEpisode(2, 1, "A Lesson for Your Next Life", 44);
		invincible.addEpisode(2, 2, "In About Six Hours I Lose My Virginity to a Fish", 46);
		invincible.addEpisode(2, 3, "This Missive, This Machination!", 45);
		invincible.addEpisode(2, 4, "It's Been a While", 47);
		invincible.addEpisode(2, 5, "This Must Come as a Shock", 46);
		invincible.addEpisode(2, 6, "It's Not That Simple", 45);
		invincible.addEpisode(2, 7, "I'm Not Going Anywhere", 44);
		invincible.addEpisode(2, 8, "I Thought You Were Stronger", 45);
		invincible.addEpisode(3, 1, "You're Not Laughing Now", 49);
		invincible.addEpisode(3, 2, "A Deal with the Devil", 49);
		invincible.addEpisode(3, 3, "You Want a Real Costume, Right?", 50);
		invincible.addEpisode(3, 4, "You Were My Hero", 49);
		invincible.addEpisode(3, 5, "This Was Supposed to Be Easy", 49);
		invincible.addEpisode(3, 6, "All I Can Say Is I'm Sorry", 54);
		invincible.addEpisode(3, 7, "What Have I Done?", 51);
		invincible.addEpisode(3, 8, "I Thought You'd Never Shut Up", 46);
		return invincible;
	}
}
