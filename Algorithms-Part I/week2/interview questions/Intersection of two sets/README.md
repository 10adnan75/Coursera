**Question:** 

Given two arrays a[] and b[], each containing n distinct 2D points in the plane, design a subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].
          
**Answer:**

Sorting both arrays would suffice the requirement of time complexity. 

Algorithm:

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

Brute force approach: [Intersection.java](https://github.com/10adnan75/DSA/blob/main/Algorithms/Arrays/Intersection.java)
