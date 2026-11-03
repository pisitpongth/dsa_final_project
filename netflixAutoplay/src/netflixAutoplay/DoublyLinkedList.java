package netflixAutoplay;

/**
 * Data structure: Doubly Linked List of Episode nodes.
 * head is the first episode. tail is the last episode.
 *
 * Algorithms:
 * - addEpisode: add at the end, O(1)
 * - size: walk from head to tail and count, O(n)
 * - find: linear search (check one episode at a time), O(n)
 */
public class DoublyLinkedList {
	private Episode head;
	private Episode tail;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	// Add the new episode at the end of the list.
	public void addEpisode(Episode newEpisode) {
		if (newEpisode == null) {
			throw new IllegalArgumentException("Episode must not be null");
		}
		if (newEpisode.getNext() != null || newEpisode.getPrevious() != null) {
			throw new IllegalArgumentException("Episode is already linked");
		}

		if (head == null) {
			head = newEpisode;
			tail = newEpisode;
		} else {
			tail.setNext(newEpisode);
			newEpisode.setPrevious(tail);
			tail = newEpisode;
		}
	}

	// Walk from the first episode to the last and count them.
	public int size() {
		int count = 0;
		Episode current = head;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}

	// Linear search: look at each episode until it matches or the list ends.
	public Episode find(int seasonNumber, int episodeNumber) {
		Episode current = head;
		while (current != null) {
			if (current.getSeasonNumber() == seasonNumber && current.getEpisodeNumber() == episodeNumber) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
}
