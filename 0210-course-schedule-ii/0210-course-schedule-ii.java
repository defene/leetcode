class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int edgeFrom = prerequisites[i][1];   
            int edgeTo = prerequisites[i][0];   
            inDegree[edgeTo]++; 

            map.putIfAbsent(edgeFrom, new ArrayList<>());
            List<Integer> adjEdges = map.get(edgeFrom);
            adjEdges.add(edgeTo);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            int curVertex = queue.poll();
            result[i++] = curVertex;

            List<Integer> adjEdges = map.get(curVertex);
            if (adjEdges != null) {
                for (int edgeTo : adjEdges) {
                    inDegree[edgeTo]--;
                    if (inDegree[edgeTo] == 0) {
                        queue.offer(edgeTo);
                    }
                }
            }
        }

        return i == numCourses ? result : new int[0];
    }
}