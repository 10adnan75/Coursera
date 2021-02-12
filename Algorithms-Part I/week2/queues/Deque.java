import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node front, rear;
    private int dequeSize;

    private class Node {
        private Item item;
        private Node next, prev;
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = front;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Deque() {
        dequeSize = 0;
        front = new Node();
        rear = new Node();
        front.item = null;
        rear.item = null;
        front.prev = null;
        front.next = rear;
        rear.prev = front;
        rear.next = null;
    }

    public boolean isEmpty() {
        return dequeSize == 0;
    }

    public int size() {
        return dequeSize;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node oldFront = front;
        front = new Node();
        front.item = item;
        front.prev = null;
        front.next = oldFront;
        if (isEmpty()) rear = front;
        else oldFront.prev = front;
        dequeSize++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        Node oldRear = rear;
        rear = new Node();
        rear.item = item;
        rear.prev = oldRear;
        rear.next = null;
        if (isEmpty()) front = rear;
        else oldRear.next = rear;
        dequeSize++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = front.item;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
        dequeSize--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = rear.item;
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null;
        }
        dequeSize--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    public static void main(String[] args) {

    }
}

