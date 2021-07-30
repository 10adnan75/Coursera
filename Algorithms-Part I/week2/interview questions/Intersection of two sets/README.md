**Question:** 

Given two arrays a[] and b[], each containing n distinct 2D points in the plane, design a subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].
          
**Answer:**

Use java.util.ArrayList and iterate through array a[] by comparing a[i] with every b[i].

Algorithm:

        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (A.get(i).getX()==B.get(j).getX() && A.get(i).getY()==B.get(j).getY()) count++;
            }
        }
        System.out.println("A intersection B: " + count);

Reference: [Intersection.java](https://github.com/10adnan75/DSA/blob/main/Algorithms/Arrays/Intersection.java)
