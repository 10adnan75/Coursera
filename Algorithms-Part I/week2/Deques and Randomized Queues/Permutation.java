import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> permutations = new RandomizedQueue<String>();
        int k = Integer.parseInt(args[0]);
        while (true) {
            if (StdIn.isEmpty()) break;
            permutations.enqueue(StdIn.readString());
        }
        while (k-- > 0) {
            StdOut.println(permutations.dequeue());
        }
    }
}
