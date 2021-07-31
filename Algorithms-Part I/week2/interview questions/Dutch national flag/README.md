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
    
    idx=0
    lo=0
    hi=pebbles.length-1
    while lo<=hi do:
      if pebbles[lo]  
            int runner = 0;
            int b = pebbles.length - 1;

            while (runner <= b) {
                Pebble color = color(runner);
                int cmp = compare(color);
                if (cmp < 0) {
                    swap(runner++, r++);
                } else if (cmp > 0) {
                    swap(runner, b--);
                } else {
                    runner++;
                }
            }
        }
        
Reference: [sort_array_0_1_2.cpp](https://github.com/10adnan75/DSA/blob/main/sort_array_0_1_2.cpp)