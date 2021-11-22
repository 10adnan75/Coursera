public class Solution {
    private UFWithMaxParent uf;
    private int n;

    private static class UFWithMaxParent {
        private int[] parent;
        private int[] size;
        private int[] max;

        public UFWithMaxParent(int n) {
            parent = new int[n];
            size = new int[n];
            max = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                max[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            int par = findWithPathCompression(p);
            return max[par];
        }

        private int findWithPathCompression(int p) {
            if (parent[p] == p) {
                return p;
            }
            parent[p] = findWithPathCompression(parent[p]);
            return parent[p];
        }

        public boolean union(int i, int j) {
            int pi = findWithPathCompression(i), pj = findWithPathCompression(j);
            if (pi == pj) return false;
            if (size[pi] < size[pj]) {
                parent[pi] = pj;
                size[pj] += size[pi];
                max[pj] = Math.max(max[pj], max[pi]);
            } else {
                parent[pj] = pi;
                size[pi] += size[pj];
                max[pi] = Math.max(max[pj], max[pi]);
            }
            return true;
        }

        public boolean connected(int i, int j) {
            return find(i) == find(j);
        }

    }

    public Solution(int n) {
        this.n = n;
        uf = new UFWithMaxParent(n + 1);
    }

    public boolean remove(int x) {
        return uf.union(x, x + 1);
    }

    public int find(int x) {
        int ret = uf.find(x);
        return ret >= n ? -1 : ret;
    }

    public static void main(String[] args) {
        Solution swd = new Solution(10);
        for (int i = 0; i < 10; i++) {
            if (swd.remove(i)) {
                System.out.print(i + " deleted!\t");
            }
            System.out.println("swd.find(" + i + "): " + swd.find(i));
        }
    }
}

/*      OUTPUT:
        0 deleted!	swd.find(0): 1
        1 deleted!	swd.find(1): 2
        2 deleted!	swd.find(2): 3
        3 deleted!	swd.find(3): 4
        4 deleted!	swd.find(4): 5
        5 deleted!	swd.find(5): 6
        6 deleted!	swd.find(6): 7
        7 deleted!	swd.find(7): 8
        8 deleted!	swd.find(8): 9
        9 deleted!	swd.find(9): -1
 */
