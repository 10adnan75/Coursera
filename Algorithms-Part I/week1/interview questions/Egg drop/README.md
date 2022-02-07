**Question:** 

Suppose that you have an n-story building (with floors 1 through n) and plenty of eggs. An egg breaks if it is dropped from floor T or higher and does not break otherwise. 

Your goal is to devise a strategy to determine the value of T given the following limitations on the number of eggs and tosses:
    
    Version 0: 1 egg, ≤T tosses.    
    Version 1: ∼1lgn eggs and ∼1lgn tosses.    
    Version 2: ∼lgT eggs and ∼2lgT tosses.    
    Version 3: 2 eggs and ∼2 sqrt(n) tosses.    
    Version 4: 2 eggs and ≤c sqrt(T) tosses for some fixed constant c.
          
---          
          
**Answer:** 

Version 0: _Try each floor starting from the bottom, the first floor that the egg breaks on is the value of T._

Version 1: _Use a binary search on the floors. First, try floor T/2. If the egg breaks, T must be equal to T/2 or smaller. If the egg does not break, T must be greater than T/2. Continue testing the mid-point of the subset of floors until T is determined._

Version 2: _Start test at floor 0 and exponentially grow (2^t) floor numbers until first egg breaks. The value of T must be between 2^t and 2^(t-1). This range can then be searched in ~lgT tosses using the technique from version 1._

Version 3: _Test floors in increments of sqrt(N) starting from floor 0. When the egg breaks on floor t, return to the previous test floor t-1 and increment by each floor. The remaining sqrt(N) tests will be enough to check each floor between floor t-1 & t. The floor that breaks will be the value of T._

Version 4: _We drop the egg at floor 1, 3(1+2), 6(1+2+3), 10(1+2+3+4), so on and so forth. Note that 1+2+3+4+…+k = k(k+1)/2 ~ (k^2)/2. Now that T = (k^2)/2, k = √(2T). From k(k−1)/2 to k(k+1)/2, we toss egg one by one, then we toss 1/2*(k^2) times. In total, we toss 2√(2T) times, thus c=2√2._

    Version 0: sequential search.
    Version 1: binary search.
    Version 2: find an interval containing T of size ≤2T, then do binary search.
    Version 3: find an interval of size sqrt(n), then do sequential search. 
    Version 4: 1 + 2 + 3 + ... + t ∼ 1/2 t^2. Aim for c = 2 sqrt(2). 

References: 

* [linear_search.cpp](https://github.com/10adnan75/DSA/blob/main/Algorithms/Searching/linear_search.cpp)           
* [BinarySearch.java](https://github.com/10adnan75/DSA/blob/main/Algorithms/Searching/Binary%20search/BinarySearch.java)
* [Stack Exchange](https://math.stackexchange.com/questions/835582/egg-drop-problem)
* [The Two Egg Problem](https://datagenetics.com/blog/july22012/index.html)
