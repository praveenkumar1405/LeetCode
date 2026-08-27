import java.util.*;

public class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] c : connections) {
            adj.get(c[0]).add(new int[]{c[1], 1});
            adj.get(c[1]).add(new int[]{c[0], 0});
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(0);
        visited[0] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int[] neighbor : adj.get(curr)) {
                int nextNode = neighbor[0];
                int isOriginalDirection = neighbor[1];

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    count += isOriginalDirection;
                    queue.offer(nextNode);
                }
            }
        }

        return count;
    }
}
