import java.util.*;

class Solution {
    private Map<String, Map<String, Double>> graph = new HashMap<>();
    private Map<String, Map<String, Double>> distMap = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }

        for (String start : graph.keySet()) {
            distMap.put(start, dijkstra(start));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            res[i] = query(x, y);
        }
        return res;
    }

    private Map<String, Double> dijkstra(String start) {
        Map<String, Double> dist = new HashMap<>();
        for (String node : graph.keySet()) {
            dist.put(node, -1.0);
        }
        dist.put(start, 1.0);

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Double.compare(b.dist,a.dist));
        pq.offer(new Node(start, 1.0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.dist < dist.get(curr.name)) continue;
            for (Map.Entry<String, Double> edge : graph.get(curr.name).entrySet()) {
                String next = edge.getKey();
                double w = edge.getValue();
                double newDist = dist.get(curr.name) * w;
                if (newDist > dist.get(next)) {
                    dist.put(next, newDist);
                    pq.offer(new Node(next, newDist));
                }
            }
        }
        return dist;
    }

    private double query(String x, String y) {
        if (!distMap.containsKey(x)) return -1.0;
        Map<String, Double> distFromX = distMap.get(x);
        return distFromX.getOrDefault(y, -1.0);
    }

    static class Node {
        String name;
        double dist;
        Node(String n, double d) {
            name = n;
            dist = d;
        }
    }
}
