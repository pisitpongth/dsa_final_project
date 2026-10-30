package netflixAutoplay;

public class ArrayList {
    private Show[] elements = new Show[10];
    private int size = 0;

    public boolean add(Show show) {
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
