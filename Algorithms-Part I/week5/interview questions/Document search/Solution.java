import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

public class Solution {
    public static void main(String[] args) {
        In input = new In("");
        String[] words = input.readAllStrings();

        ST<String, Queue<Integer>> wIndices = new ST<>();

        for (int i = 0; i < words.length; i++) {
            if (!wIndices.contains(words[i])) {
                Queue<Integer> temp = new Queue<>();
                temp.enqueue(i);
                wIndices.put(words[i], temp);
            } else {
                Queue<Integer> temp = wIndices.get(words[i]);
                temp.enqueue(i);
                wIndices.put(words[i], temp);
            }
        }
        int bestLo = -1;
        int bestHi = words.length;
        String[] query = StdIn.readAllStrings();
        Queue<Integer>[] queues = (Queue<Integer>[]) new Queue[query.length];

        for (int i = 0; i < query.length; i++) {
            queues[i] = wIndices.get(query[i]);
        }

        Queue<Integer> starts = wIndices.get(query[0]);

        for (Integer start : starts) {
            boolean end = true;
            int lo = start;
            int hi = lo;

            for (int i = 1; i < queues.length; i++) {
                while (!queues[i].isEmpty() && queues[i].peek() <= hi) queues[i].dequeue();
                if (queues[i].isEmpty()) {
                    end = false;
                    break;
                } else {
                    hi = queues[i].peek();
                }
            }

            if (end && hi - lo < bestHi - bestLo) {
                bestHi = hi;
                bestLo = lo;
            }
        }

        if (bestLo >= 0) {
            int interval = bestHi - bestLo;
            System.out.println("Shortest interval found: " + interval);
        } else {
            System.out.println("Not found!");
        }

    }
}
