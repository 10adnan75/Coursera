**Question:**

Given a set of nn integers S = {0, 1, ..., n − 1} and a sequence of requests of the following form:
    
+ Remove x from S
+ Find the successor of x: the smallest y in S such that y≥x.
          
design a data type so that all operations (except construction)  take logarithmic time or better in the worst case.

---

**Answer:**

Modify union-find data in such a way that it contains a method remove(x) which would union x with its successor x+1. Implement a method successor(x) which returns the root of x.

Algorithm:
    
    public class SuccessorWithDelete 
        private UFWithMaxParent uf
        private int n

        public SuccessorWithDelete(int n) 
            this.n = n
            uf = new UFWithMaxParent(n + 1)

        public boolean remove(int x) 
            return uf.union(x, x + 1)

        public int find(int x) 
            int ret = uf.find(x)
            return ret >= n ? -1 : ret

References:

+ [UFWithMaxParent](https://github.com/10adnan75/Coursera/blob/main/Algorithms-Part%20I/week1/interview%20questions/Union-find%20with%20specific%20canonical%20element/Solution.java)
