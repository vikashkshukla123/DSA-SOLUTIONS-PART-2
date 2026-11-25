class Solution {
    public int shortestPathLength(int[][] graph) {
       Queue<int[]>q = new ArrayDeque<>();
       int n = graph.length;
       int totalVal = (int)Math.pow(2,n) - 1;
       boolean [][]visited = new boolean[n+1][totalVal + 1];
       for(boolean []vis : visited){
        Arrays.fill(vis,false);
       }
       for(int i = 0; i < n; i++){
        int node = i;
        int bitSet = (1 << node);
        q.offer(new int[]{node,bitSet});
        visited[node][bitSet] = true;
       }

       int ans = Integer.MAX_VALUE;
       int steps = 0;
       while(!q.isEmpty()){
        int sz = q.size();
        for(int i = 0; i < sz; i++){
            int []front = q.poll();
            int node = front[0];
            int bitVal = front[1];


            if(bitVal == totalVal){
                return steps;
            }


            for(int ngbr : graph[node]){
                int ngbrNode = ngbr;

                int newBitSet = bitVal | (1 << ngbrNode);

                if(visited[ngbrNode][newBitSet] == true) continue;
                q.offer(new int[]{ngbrNode,newBitSet});
                visited[ngbrNode][newBitSet] = true;
            }
        }
        
        steps++;
       }


       return ans;
        
    }
}