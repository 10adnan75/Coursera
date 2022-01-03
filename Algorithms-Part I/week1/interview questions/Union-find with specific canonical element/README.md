**Question:** 

Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing i. 

- The operations, union(), connected(), and find() should all take logarithmic time or better.
- For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9 for each of the four elements in the connected components.

---

**Answer:**

Create a new array which stores the maximum element for each root, return the maximum element of the connected component when find(i) is called.

Algorithm:

    public class UnionFindCanonical 
        private WeightedQuickUnionUF uf
        private int[] max, parent, size, total

        public UnionFindCanonical(int n)
            uf = new WeightedQuickUnionUF(n)
            max = new int[n]
            parent = new int[n]
            size = new int[n]
            total = n
            for i = 0 to n do
                max[i] = i
                parent[i] = i
                size[i] = 1
            end for

        public int find(int i)
            while i != parent[i] do
                i = parent[i]
            end while
            return i

        public boolean connected(int p, int q)
            return uf.find(p) == uf.find(q)

        public void union(int p, int q)
            uf.union(p,q)
            rootP = find(p)
            rootQ = find(q)
            if rootP == rootQ 
                return
            end if
            if size[rootP] < size[rootQ]
                parent[rootP] = rootQ
                size[rootQ] += size[rootP]
                max[rootQ] = Math.max(max[rootP], max[rootQ])
            else 
                parent[rootQ] = rootP
                size[rootP] += size[rootQ]
                max[rootP] = Math.max(max[rootP], max[rootQ])
            end if

        public int count()
            return uf.count()
        
        public int findMax(int p)
            return max[uf.find(p)]
            
References:

+ [WeightedQuickUnionUF.java](https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/WeightedQuickUnionUF.java.html)
