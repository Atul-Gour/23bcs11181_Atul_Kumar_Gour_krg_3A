class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        
        for (int i = 0; i < V; i++)
            dist[i] = (int)1e8;

        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (dist[u] != (int)1e8 && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (dist[u] != (int)1e8 && dist[u] + w < dist[v])
                return new int[]{-1};
        }

        return dist;
    }
}