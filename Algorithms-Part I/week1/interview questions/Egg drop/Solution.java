import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    private int n;
    private boolean[] Floors;
    private int T;
    
    public Solution(int floors, boolean[] Floors) {
        this.n = floors;
        for (int i=0; i<this.n; i++) {
            this.Floors[i] = Floors[i];
        }
        this.T = 0;
    }
    
    public static int version_0(int n, boolean[] Floors, int eggs, int tosses) {
        int T = 0;
        for (int i=0; i<n; i++) {
            if (Floors[i] == true) {
                T = i;
                break;
            }
        }
        return T + 1;   
    }
    
    public static int version_1(int n, boolean[] Floors, int eggs, int tosses) {
        int lo = 0, hi = n-1, T = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (Floors[mid] == true) {
                hi = mid - 1;
                if (mid < T) {
                    T = mid;
                } else {
                    return T;
                }
            } else {
                lo = mid + 1;
            }
        }
        return T + 1;   
    }
    
    public static int version_2(int n, boolean[] Floors, int eggs, int tosses) {
        int T = 0;
        return T + 1;
    }
    
    public static int version_3(int n, boolean[] Floors, int eggs, int tosses) {
        int T = 0;
        return T + 1;  
    }
    
    public static int version_4(int n, boolean[] Floors, int eggs, int tosses) {
        int T = 0;
        return T + 1;
    }
    
	public static void main (String[] args) throws java.lang.Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("How many floors?: "); int floors = input.nextInt();
		System.out.print("Enter T: "); int T = input.nextInt();
		boolean[] Floors =  new boolean[floors];
		System.out.println("Enter 'true' if breaks else 'false'.");
		for (int i=0; i<floors; i++) {
		    System.out.print("Floor " + (i+1) + ": ");
		    Floors[i] = input.nextBoolean();
		}
		// Solution solution = new Solution(floors, Floors);
		int c = 7;
		System.out.println("Version 0: Floor " + version_0(floors, Floors, 1, T));
		System.out.println("Version 1: Floor " + version_1(floors, Floors, (int)Math.log(floors), (int)Math.log(floors)));
		System.out.println("Version 2: Floor " + version_2(floors, Floors, (int)Math.log(T), (int)(2*Math.log(T))));
		System.out.println("Version 3: Floor " + version_3(floors, Floors, 2, (int)(2*Math.sqrt(floors))));
		System.out.println("Version 4: Floor " + version_4(floors, Floors, 2, (int)(c*Math.sqrt(T))));
	}
}
