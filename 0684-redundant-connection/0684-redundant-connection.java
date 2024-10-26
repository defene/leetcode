class Solution {
    class DisjointSet {
        int[] parent;
        int[] rank;

        public DisjointSet(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            rank = new int[size];
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int xr = find(x);
            int yr = find(y);

            if (xr == yr) {
                return false;
            } else if (rank[xr] > rank[yr]) {
                parent[yr] = xr;
            } else if (rank[xr] < rank[yr]) {
                parent[xr] = yr;
            } else {
                parent[yr] = xr;
                xr++;
            }

            return true;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet djs = new DisjointSet(edges.length + 1);
        for (int[] edge : edges) {
            if (!djs.union(edge[0], edge[1])) {
                return edge;
            }
        }

        throw new AssertionError();
    }
}