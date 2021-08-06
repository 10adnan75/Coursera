import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    
    private boolean binSearch(int[] a, int left, int right, int key) {
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
		
	}
}
