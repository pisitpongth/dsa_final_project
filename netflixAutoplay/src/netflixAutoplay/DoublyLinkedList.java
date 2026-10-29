package netflixAutoplay;

public class DoublyLinkedList {
	Episode head;
	Episode tail;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	// ฟังก์ชันเพิ่มตอนใหม่ต่อท้าย (O(1))
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