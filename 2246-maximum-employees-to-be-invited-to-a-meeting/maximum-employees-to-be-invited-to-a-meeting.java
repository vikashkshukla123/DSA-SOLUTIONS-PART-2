class Solution {
    int bfs(int node,boolean[]visited,Map<Integer,List<Integer>>adj){
        int maxiLength = 0;
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{node,0});
        while(!pq.isEmpty()){
            int[]curr = pq.poll();

            int Node = curr[0];
            int level = curr[1];
            for(int ngbr : adj.getOrDefault(Node,new ArrayList<>())){
                if(!visited[ngbr]){
                    maxiLength = Math.max(maxiLength, level + 1);
                    pq.offer(new int[]{ngbr , level + 1});
                    visited[ngbr] = true;
                }


            }
        }

        return maxiLength;
    }
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        Map<Integer,List<Integer>>adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            int u = i;
            int v = favorite[i];
            adj.putIfAbsent(v,new ArrayList<>());
            adj.get(v).add(u); 
        }

        int longestCycleCount = 0;
        int happyCoupleCount = 0;
        boolean []visited = new boolean[n];
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                Map<Integer,Integer>mp = new HashMap<>();
                int currNode = i;
                int currNodeCount = 0;

                while(!visited[currNode]){
                    visited[currNode] = true;
                    mp.put(currNode,currNodeCount);

                    int nextNode = favorite[currNode];
                    currNodeCount++;

                    if(mp.containsKey(nextNode)){
                        int cycleLength = currNodeCount - mp.getOrDefault(nextNode,0);
                        longestCycleCount = Math.max(longestCycleCount, cycleLength);

                        if(cycleLength == 2){
                            boolean []visited1 = new boolean[n];
                            for(int j = 0; j < n; j++){
                                visited1[j] = false;
                            }
                            visited1[currNode] = true;
                            visited1[nextNode] = true;
                            happyCoupleCount += 2 + bfs(currNode,visited,adj) + bfs(nextNode,visited1,adj);
                        }
                        break;
                    }


                    currNode = nextNode;

                }
            }
        }
        return Math.max(longestCycleCount, happyCoupleCount);
    }
}