import java.util.Arrays;
import java.util.Scanner;

class Solution {
    
    public static boolean isPermutation(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i=0; i<a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size: ");
        int aSize = input.nextInt();
        int[] a = new int[aSize]; 
        System.out.println("Enter 1st array elements: ");
        for (int i=0; i<aSize; i++) a[i] = input.nextInt();
        System.out.print("Enter size: ");
        int bSize = input.nextInt();
        int[] b = new int[bSize];
        System.out.println("Enter 2nd array elements: ");
        for (int i=0; i<bSize; i++) b[i] = input.nextInt();
        
        if (isPermutation(a, b)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

/*      OUTPUT:
        Enter size: 5
        Enter 1st array elements: 1 2 3 4 5
        Enter size: 6
        Enter 2nd array elements: 5 3 2 1 4 0
        No
*/
