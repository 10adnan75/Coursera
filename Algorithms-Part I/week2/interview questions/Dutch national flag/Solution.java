import java.util.*;

class Solution {
    
    enum Pebble {
        Red,
        White,
        Blue
    }

    private static class Bucket {
        private Pebble[] pebbles;
        
        private Bucket(Pebble[] pebbles) {
            this.pebbles = new Pebble[pebbles.length];
            for (int i=0; i<pebbles.length; i++) {
                this.pebbles[i] = pebbles[i];
            }
        }

        private Pebble color(int i) {
            return pebbles[i];
        }

        private int compare(Pebble p) {
            Pebble white = Pebble.White;
            return p.ordinal() - white.ordinal();
        }

        private void swap(int i, int j) {
            Pebble tmp = pebbles[i];
            pebbles[i] = pebbles[j];
            pebbles[j] = tmp;
        }

        public void sort() {
            assert pebbles.length > 0;
            int r = 0;
            int runner = 0;
            int b = pebbles.length - 1;

            while (runner <= b) {
                Pebble color = color(runner);
                int cmp = compare(color);
                if (cmp < 0) {
                    swap(runner++, r++);
                } else if (cmp > 0) {
                    swap(runner, b--);
                } else {
                    runner++;
                }
            }
        }
        
        public void display() {
            for (int i=0; i<pebbles.length; i++) {
                System.out.print(pebbles[i] + " ");
            }
        }
    }
    
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many pebbles?: "); int size = input.nextInt();
        Pebble[] pebbles = new Pebble[size];
        Pebble[] colors = {Pebble.Red, Pebble.White, Pebble.Blue};
        Random rand = new Random();
        for (int i=0; i<size; i++) {
            int idx = rand.nextInt(3);
            pebbles[i] = colors[idx];
        }
        
        System.out.print("Randomly inserted pebbles in bucket: "); 
        for (int i=0; i<size; i++) System.out.print(pebbles[i] + " ");
        
        Bucket bucket = new Bucket(pebbles);
        bucket.sort();
        System.out.print("\nSorted bucket: "); 
        bucket.display();
    }
}

/*      How many pebbles?: 20
        Randomly inserted pebbles in bucket: Blue White White Red Blue Blue Red White White White White Red Red White Red White White White White Red 
        Sorted bucket: Red Red Red Red Red Red White White White White White White White White White White White Blue Blue Blue 
 */
