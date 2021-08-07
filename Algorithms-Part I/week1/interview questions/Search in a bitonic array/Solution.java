import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    
    private static boolean binSearch(int[] a, int left, int right, int key) {
        if (a[left] < a[right]) {
            while (left < right) {
                int mid = left + (right-left)/2;
                if (a[mid] < key) {
                    left = mid+1;
                } else if (a[mid] > key) {
                    right = mid-1;
                } else {
                    return true;
                }
            }
        } else {
            while (left < right) {
                int mid = left + (right-left)/2;
                if (a[mid] < key) {
                    right = mid-1;
                } else if (a[mid] > key) {
                    left = mid+1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean search(int[] a, int key) {
        int left = 0;
        int right = a.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (a[mid] < key) {
                if (a[mid] < a[mid+1]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            } else if (a[mid] > key) {
                if (a[mid] < a[mid+1]) {
                    if (binSearch(a, 0, mid-1, key)) {
                        return true;
                    } else {
                        left = mid+1;
                    }
                } else {
                    if (binSearch(a, mid+1, a.length-1, key)) {
                        return true;
                    } else {
                        right = mid-1;
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }
    
    
	public static void main(String[] args) throws java.lang.Exception {
		int[] a = {10, 20, 30, 40, 50, 5, 4, 3, 2, 1};
		int[] keys = {7, 10, 100, 99, 2, 5, 786};
		for (int key : keys) {
		    if (search(a, key)) {
		        System.out.println(key + " is present in array!");
		    } else {
		        System.out.println(key + " is absent in array!");
		    }
		}
	}
}

/*      OUTPUT:
        7 is absent in array!
        10 is present in array!
        100 is absent in array!
        99 is absent in array!
        2 is present in array!
        5 is present in array!
        786 is absent in array!
 */
