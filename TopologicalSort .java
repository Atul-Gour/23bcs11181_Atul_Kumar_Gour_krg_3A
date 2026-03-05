import java.util.*;

public class TopologicalSort {

    public static List<Integer> topoSort(int V, List<List<Integer>> adj) {

        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int v : adj.get(node)) {
                indegree[v]--;
                if (indegree[v] == 0)
                    q.add(v);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> order = topoSort(V, adj);

        System.out.println(order);
    }
}