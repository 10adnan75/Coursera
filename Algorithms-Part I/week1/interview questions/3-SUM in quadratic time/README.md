**Question:** 

Design an algorithm for the 3-SUM problem that takes time proportional to n^2 in the worst case.           
You may assume that you can sort the n integers in time proportional to n^2 or better.
          
**Answer:** 

First, sort the array using mergesort algorithm in the time proportional to nlogn. 

Algorithm:

    for i = 0 to array.length - 2 do
        j = i + 1
        k = array.length - 1
        while j < k do
            sum = array[i] + array[j] + array[k]
            if sum = 0 
                print sum
            end if
            if sum >= 0
                k -= 1
            else 
                j += 1
            end if
        end while
    end for

References: 

* [ThreeSumFast.java](https://github.com/10adnan75/DSA/blob/main/Algorithms/Arrays/ThreeSumFast.java)           
* [two_pointers_3sum.cpp](https://github.com/10adnan75/DSA/blob/main/Algorithms/Searching/Binary%20search/two_pointers_3sum.cpp)
* [ThreeSum.java](https://github.com/10adnan75/DSA/blob/main/Algorithms/Arrays/ThreeSum.java)
