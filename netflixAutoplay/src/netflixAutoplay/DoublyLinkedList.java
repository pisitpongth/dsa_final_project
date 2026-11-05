package netflixAutoplay;

public class DoublyLinkedList {
    Episode head;
    Episode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addEpisode(Episode newEpisode) {
        if (newEpisode == null) {
            throw new IllegalArgumentException("Episode must not be null");
        }
        if (newEpisode.next != null || newEpisode.previous != null) {
            throw new IllegalArgumentException("Episode is already linked");
        }

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