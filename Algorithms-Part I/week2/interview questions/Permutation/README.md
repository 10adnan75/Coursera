**Question:**

Given two integer arrays of size n, design a subquadratic algorithm to determine whether one is a permutation of the other. 
That is, do they contain exactly the same entries but, possibly, in a different order.

**Answer:**

Sort both arrays and iterate through the elements to check for equality which would require n compares.

Algorithm:

    if a.length != b.length
        return false
    end if
    for i = 0 to size - 1 do
        if a[i] != b[i]
            return false
        end if
    end for
    return true

Reference: []()
