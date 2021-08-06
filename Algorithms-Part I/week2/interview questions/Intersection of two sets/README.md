**Question:** 

Given two arrays a[] and b[], each containing n distinct 2D points in the plane, design a subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].

---

**Answer:**

Sorting both arrays would suffice the requirement of time complexity. 

Algorithm:

    i = 0
    j = 0
    while i < a.length and j < b.length do
        if a[i] == b[j]  
            count += 1
            i += 1
            j += 1
        else if a[i] < b[j]
            i += 1
        else 
            j += 1
        end if
    end while

Brute force approach: [Intersection.java](https://github.com/10adnan75/DSA/blob/main/Algorithms/Arrays/Intersection.java)
