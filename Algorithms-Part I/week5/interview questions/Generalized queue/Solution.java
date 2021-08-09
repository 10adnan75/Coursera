import java.lang.*;
import java.util.Scanner;

public class Solution {

    private static class GeneralizedQueue<Item> {
        private int index;
        private final RedBlackBST<Integer, Item> store;

        GeneralizedQueue() {
            index = 0;
            store = new RedBlackBST<>();
        }

        public void append(Item item) {
            store.put(index++, item);
        }

        public void removeFront() {
            store.deleteMin();
        }

        public Item get(int i) {
            int key = store.rank(i);
            return store.get(key);
        }

        public void delete(int i) {
            store.delete(store.rank(i));
        }

        public void display() {
            for (int key : store.keys()) System.out.print(" | " + (key+1) + " -> " + store.get(key) + " | ");
            System.out.println();
        }
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        GeneralizedQueue<Integer> queue = new GeneralizedQueue<>();

        System.out.print("Enter keys: ");
        String s = input.nextLine();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != ' ') queue.append((Integer.parseInt(String.valueOf(s.charAt(i)))));
        }

        System.out.print("Initial queue: "); queue.display();
        queue.removeFront(); // removing front
        System.out.print("After removing front: "); queue.display();

        System.out.print("Enter index to get the key: "); int index = input.nextInt();
        System.out.println("Key at index " + index + ": " + queue.get(index));

        System.out.print("Enter index to delete key: "); int del = input.nextInt();
        queue.delete(del);
        System.out.print("Queue after deletion: "); queue.display();
    }
}

/*      OUTPUT:
        Enter keys: 1 2 3 4 5 6 7 8 9
        Initial queue:  | 1 -> 1 |  | 2 -> 2 |  | 3 -> 3 |  | 4 -> 4 |  | 5 -> 5 |  | 6 -> 6 |  | 7 -> 7 |  | 8 -> 8 |  | 9 -> 9 | 
        After removing front:  | 2 -> 2 |  | 3 -> 3 |  | 4 -> 4 |  | 5 -> 5 |  | 6 -> 6 |  | 7 -> 7 |  | 8 -> 8 |  | 9 -> 9 | 
        Enter index to get the key: 1
        Key at index 1: null
        Enter index to delete key: 5
        Queue after deletion:  | 2 -> 2 |  | 3 -> 3 |  | 4 -> 4 |  | 6 -> 6 |  | 7 -> 7 |  | 8 -> 8 |  | 9 -> 9 | 
 */
