class Solution {
    class Edge {
        boolean direction;
        int nextNode;

        public Edge(int num, int nextNode) {
            this.direction = num > 0;
            this.nextNode = nextNode;
        }
    }
    
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        Edge[] edges = new Edge[n];

        for (int i = 0; i < n; i++) {
            int edgeTo = (i + nums[i] + 1000 * n) % n;
            edges[i] = new Edge(nums[i], edgeTo);
        }

        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dfs(edges, visited, inStack, i, edges[i].direction)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(Edge[] edges, boolean[] visited, boolean[] inStack, int cur, boolean direction) {
        if (inStack[cur]) return edges[cur].direction == direction;
        if (visited[cur] || edges[cur].direction != direction) return false;

        visited[cur] = true;
        inStack[cur] = true;
        if (edges[cur].nextNode == cur) {
            inStack[cur] = false;
            return false;
        }
        if (dfs(edges, visited, inStack, edges[cur].nextNode, direction)) {
            return true;
        }

        inStack[cur] = false;
        return false;
    }
}