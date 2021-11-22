**Question:**

Given a set of nn integers S = {0, 1, ..., n − 1} and a sequence of requests of the following form:
    
+ Remove x from S
+ Find the successor of x: the smallest y in S such that y≥x.
          
design a data type so that all operations (except construction)  take logarithmic time or better in the worst case.

---

**Answer:**

Modify union-find data in such a way that it contains a method remove(x) which would union x with its successor x+1. Implement a method successor(x) which returns the root of x.

Algorithm:
    
    here

References:

+ []()
