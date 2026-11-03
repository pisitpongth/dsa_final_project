package netflixAutoplay;

/**
 * Data structure: Dynamic Array (our own ArrayList) of Show.
 * It starts with space for 10 shows. When it is full, the array grows to 2 times the size.
 *
 * Algorithms:
 * - add: usually O(1). If the array is full, copy to a bigger array, then add.
 * - get: read by index, O(1)
 * - size: return the count, O(1)
 */
public class ShowList {
	private Show[] elements = new Show[10];
	private int size = 0;

	public boolean add(Show show) {
		// Make a new array that is 2 times bigger, then copy the old shows.
		if (size == elements.length) {
			Show[] newElements = new Show[elements.length * 2];

			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}

			elements = newElements;
		}

		elements[size] = show;
		size++;
		return true;
	}

	// Get a show by its position. No need to walk a list.
	public Show get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}

		return elements[index];
	}

	public int size() {
		return size;
	}
}
