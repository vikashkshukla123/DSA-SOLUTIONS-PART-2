class Solution {
    public long[]dijkstra(int src,Map<Integer, List<int[]>> adj, int n){
        long[]dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[src] = 0;
        pq.offer(new long[]{0, src});
        while (!pq.isEmpty()) {

            long[] top = pq.poll();

            long distance = top[0];
            int node = (int) top[1];

            if (distance > dist[node]) continue;

            for (int[] ngbr : adj.get(node)) {

                int ngbrNode = ngbr[0];
                int wt = ngbr[1];

                if (distance + wt < dist[ngbrNode]) {

                    dist[ngbrNode] = distance + wt;

                    pq.offer(new long[]{
                        dist[ngbrNode], ngbrNode
                    });
                }
            }
        }

        return dist;
    }
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        Map<Integer,List<int[]>> adj = new HashMap<>();
        Map<Integer,List<int[]>>adj2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
            adj2.put(i, new ArrayList<>());
          }

        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

           adj.get(u).add(new int[]{v,w});
           adj2.get(v).add(new int[]{u,w});
   
        }

        long[] minDist1 = dijkstra(src1, adj, n);
        long[] minDist2 = dijkstra(src2, adj, n);
        long[] minDist3 = dijkstra(dest, adj2, n);


       
       long ans = Long.MAX_VALUE;
       for(int i = 0; i < n; i++){
        if(minDist1[i] != Long.MAX_VALUE && minDist2[i] != Long.MAX_VALUE && minDist3[i] != Long.MAX_VALUE){
            ans = Math.min(ans, minDist1[i] + minDist2[i] + minDist3[i]);
        }
       }



return (ans == Long.MAX_VALUE ? -1 : ans);
        
    }
}
