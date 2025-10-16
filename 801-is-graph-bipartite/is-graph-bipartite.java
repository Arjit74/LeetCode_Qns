import java.util.*;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> visited = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (visited.containsKey(i)) continue;

            queue.offer(new Pair(i, 0));
            visited.put(i, 0);

            while (!queue.isEmpty()) {
                Pair current = queue.poll();

                for (int neighbor : graph[current.node]) {
                    if (!visited.containsKey(neighbor)) {
                        visited.put(neighbor, 1 - visited.get(current.node));
                        queue.offer(new Pair(neighbor, visited.get(neighbor)));
                    } else if (visited.get(neighbor) == visited.get(current.node)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static class Pair {
        int node;
        int color;

        Pair(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }
}