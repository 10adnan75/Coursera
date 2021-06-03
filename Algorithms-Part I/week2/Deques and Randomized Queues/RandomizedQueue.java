import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] randomizedQueue;
    private int queSize;

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Item[] copyRandomizedQueue = (Item[]) new Object[randomizedQueue.length];
        private int copySize = queSize;

        public RandomizedQueueIterator() {
            for (int i = 0; i < randomizedQueue.length; i++) {
                copyRandomizedQueue[i] = randomizedQueue[i];
            }
        }

        public boolean hasNext() {
            return copySize > 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int rd = StdRandom.uniform(copySize);
            Item item = copyRandomizedQueue[rd];
            if (rd != copySize - 1) copyRandomizedQueue[rd] = copyRandomizedQueue[copySize - 1];
            copyRandomizedQueue[copySize - 1] = null;
            copySize--;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public RandomizedQueue() {
        queSize = 0;
        randomizedQueue = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return queSize == 0;
    }

    public int size() {
        return queSize;
    }

    private void resize(int capacity) {
        Item[] newRandomizedQueue = (Item[]) new Object[capacity];
        for (int i = 0; i < queSize; i++) {
            newRandomizedQueue[i] = randomizedQueue[i];
        }
        randomizedQueue = newRandomizedQueue;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (queSize == randomizedQueue.length) resize(randomizedQueue.length * 2);
        randomizedQueue[queSize++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int randomIndex = StdRandom.uniform(queSize);
        Item item = randomizedQueue[randomIndex];
        if (randomIndex != queSize - 1) randomizedQueue[randomIndex] = randomizedQueue[queSize - 1];
        randomizedQueue[queSize - 1] = null;
        queSize--;
        if (queSize > 0 && queSize == randomizedQueue.length / 4) resize(randomizedQueue.length / 2);
        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return randomizedQueue[StdRandom.uniform(queSize)];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    public static void main(String[] args) {

    }
}
