package netflixAutoplay;

public class DoublyLinkedList {
	Episode head;
	Episode tail;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addEpisode(Episode newEpisode) {
		if (head == null) {
			head = newEpisode;
			tail = newEpisode;
		} else {
			tail.next = newEpisode;
			newEpisode.previous = tail;
			tail = newEpisode;
		}
	}
}