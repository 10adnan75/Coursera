import java.util.*;

class Solution {
    
    private static boolean sum(int[] a, int key) {
        int value = a[key];
        for (int left=0; left<a.length-3; left++) {
            int mid = left+1;
            int right = a.length-1;
            while (mid < right) {
                if (mid == key || a[left] + a[mid] + a[right] < value) {
                    mid++;
                } else if (right == key || a[left] + a[mid] + a[right] > value) {
                    right--;
                } else {
                    System.out.println(a[left] + " + " + a[mid] + " + " + a[right] + " = " + value);
                    mid++;
                    right--;
                    //return true;
                }
            }
        }
        return false;
    }

    public static boolean threeSum(int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (sum(a, i)) return true;
        }
        return false;
    }
    
    public static void main (String[] args) {
        int[] a = {2, 1, -1, 5, 8, 0, -2};
        System.out.println(threeSum(a));
    }
}
/*      OUTPUT:
        -2 + -1 + 1 = -2
        -2 + 0 + 1 = -1
        -1 + 0 + 2 = 1
        -2 + -1 + 5 = 2
        -2 + -1 + 8 = 5
        1 + 2 + 5 = 8
        false
 */
