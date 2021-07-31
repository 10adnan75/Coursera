**Question:**

Given an array of n buckets, each containing a red, white, or blue pebble, sort them by color. 

The allowed operations are:

    swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
    
    color(i): determine the color of the pebble in bucket i.

The performance requirements are as follows:

    At most n calls to color().
    At most n calls to swap().
    Constant extra space.
          
**Answer:**

Use algorithm for 3-way-partitioning.

Algorithm:
    
    white = Pebble.white
    idx = 0
    lo = 0
    hi = pebbles.length - 1
    while lo <= hi do
        if pebbles[lo] < white 
            swap(lo, idx)
            lo += 1
            idx += 1
        else if pebbles[lo] > white 
            swap(lo, hi)
            hi -= 1
        else
            lo += 1
        end if
    end while
        
References: 

* [DutchNationalFlag.java](https://github.com/10adnan75/DSA/blob/main/Algorithms/Arrays/DutchNationalFlag.java)
* [sort_array_0_1_2.cpp](https://github.com/10adnan75/DSA/blob/main/Algorithms/Arrays/sort_array_0_1_2.cpp)
