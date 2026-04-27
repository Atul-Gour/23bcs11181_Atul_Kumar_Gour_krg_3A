import java.util.*;

public class PrimsArray {

    public static int prims(int V, List<List<int[]>> adj) {
        boolean[] visited = new boolean[V];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        pq.add(new int[]{0, 0});

        int sum = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int wt = curr[1];

            if (visited[node]) continue;

            visited[node] = true;
            sum += wt;

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWt = neighbor[1];

                if (!visited[adjNode]) {
                    pq.add(new int[]{adjNode, edgeWt});
                }
            }
        }

        return sum;
    }
}