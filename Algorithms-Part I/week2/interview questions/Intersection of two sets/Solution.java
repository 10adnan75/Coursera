import java.util.*;

class Solution {
    
    private static class Point implements Comparable<Point> {
        
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point that) {
            if (that.x > this.x) return -1;
            if (that.x < this.x) return 1;
            if (that.y > this.y) return -1;
            if (that.y < this.y) return 1;
            return 0;
        }
    }
    
    public static void sort(Point[] arr) {
        for (int i=1; i<arr.length; i++) {
            Point key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j].compareTo(key) > 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static int countIntersection(Point[] a, Point[] b) {
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) == 0) {
                count++;
                i++;
                j++;
            } else if (a[i].compareTo(b[j]) < 0) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("How many points?: ");
        int n = input.nextInt();
        Point[] a = new Point[n];
        Point[] b = new Point[n];
        System.out.println("Input values for Set A and Set B: ");
        for (int id=0; id<n; id++) {
            System.out.print("A.x" + id+1 + ": ");
            int ax = input.nextInt();
            System.out.print("A.y" + id+1 + ": ");
            int ay = input.nextInt();
            a[id] = new Point(ax, ay);
            System.out.print("B.x" + id+1 + ": ");
            int bx = input.nextInt();
            System.out.print("B.y" + id+1 + ": ");
            int by = input.nextInt();
            b[id] = new Point(bx, by);
        }
        
        sort(a); sort(b);
        System.out.println("A: ");
        for (int id=0; id<n; id++) System.out.println(a[id].x + " " + a[id].y);
        System.out.println("B: ");
        for (int id=0; id<n; id++) System.out.println(b[id].x + " " + b[id].y);
        System.out.println("A intersection B: " + countIntersection(a, b));
    }
}
