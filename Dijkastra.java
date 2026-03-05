import java.util.*;
class Solution {

    public int[] dijkstra(int V, int[][] edges, int src) {

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        @SuppressWarnings("unchecked")
        ArrayList<int[]>[] adj = new ArrayList[V];

        for(int i=0;i<V;i++)
            adj[i] = new ArrayList<>();

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj[u].add(new int[]{v,w});
            adj[v].add(new int[]{u,w});
        }

        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src] = 0;

        pq.offer(new int[]{src,0});

        while(!pq.isEmpty()){

            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if(d > dist[node]) continue;

            for(int[] edge : adj[node]){

                int neigh = edge[0];
                int wt = edge[1];

                if(dist[neigh] > d + wt){

                    dist[neigh] = d + wt;
                    pq.offer(new int[]{neigh,dist[neigh]});

                }
            }
        }

        return dist;
    }
}