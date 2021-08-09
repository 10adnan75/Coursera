**Question:**

An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of n distinct integer values, determines whether a given integer is in the array.

    Standard version: Use 3lgn compares in the worst case.
    Signing bonus: Use 2lgn compares in the worst case (and prove that no algorithm can guarantee to perform fewer than 2lgn compares in the worst case).
          
---

**Answer:** 

Use three binary searches.
    
    1) Locate the point in the array where ascending switches to descending and call it as peak.
    2) Perform binary search on each half of the array for the target integer.
    
Algorithm:

    left = 0 
    right = a.length-1
    while left < right do
        mid = left + (right - left) / 2
        if a[mid] < key
            if a[mid] < a[mid+1] 
                left = mid + 1
            else 
                right = mid - 1
            end if
        else if a[mid] > key 
            if a[mid] < a[mid+1] 
                if binSearch(a, 0, mid-1, key) = true
                    return true
                else 
                    left = mid + 1
                end if
            else 
                if binSearch(a, mid+1, a.length-1, key) = true
                    return true
                else 
                    right = mid - 1
                end if
            end if
        else 
            return true
        end if
    end while
    return false

Reference: [SearchBitonicArray.java](https://github.com/10adnan75/DSA/blob/main/Algorithms/Searching/Binary%20search/SearchBitonicArray.java)
