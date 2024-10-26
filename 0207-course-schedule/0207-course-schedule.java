class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = build(numCourses, prerequisites);
        int[] visitStatus = new int[numCourses]; // 0 represents unvisited, 1 represents visiting, 2 represents visited

        boolean result = true;
        for (int course = 0; course < numCourses; course++) {
            if (visitStatus[course] == 0) {
                result = dfs(graph, visitStatus, course);
            }
            if (!result) break;
        }

        return result;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int[] visitStatus, int curNode) {
        List<Integer> adjNodes = graph.get(curNode);
        if (adjNodes == null) {
            return true;
        }
        
        for (int adjNode : adjNodes) {
            if (visitStatus[adjNode] == 0) {
                visitStatus[adjNode] = 1;
                if (!dfs(graph, visitStatus, adjNode)) {
                    return false;
                }
                visitStatus[adjNode] = 2;
            } else if (visitStatus[adjNode] == 1) {
                return false;
            }
        }

        return true;
    }

    private Map<Integer, List<Integer>> build(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int edgeFrom = prerequisite[1];
            int edgeTo = prerequisite[0];

            graph.putIfAbsent(edgeFrom, new ArrayList<>());
            List<Integer> adjNodes = graph.get(edgeFrom);
            adjNodes.add(edgeTo);
        } 

        return graph;      
    }
}