class Solution {
    int ans;
    boolean []visited;
    boolean []inRecursion;
    int []cnt;
    void dfs(int node, int[]edges,boolean []visited, boolean []inRecursion, int[]cnt){
        int n = edges.length;
        visited[node] = true;
        inRecursion[node] = true;

        int nextEdge = edges[node];
        if(nextEdge != -1){

        if(!visited[nextEdge]){
            cnt[nextEdge] = 1 + cnt[node];
            dfs(nextEdge, edges, visited, inRecursion, cnt);
            
            inRecursion[node] = false;
        }else if(visited[nextEdge] && inRecursion[nextEdge] == true){
            ans = Math.max(ans, cnt[node] - cnt[nextEdge] + 1);
           }


        }

        inRecursion[node] = false;



    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        visited = new boolean [n];
        inRecursion = new boolean[n];
        cnt = new int[n];
        for(int i = 0; i < n; i++){
            visited[i] = false;
            inRecursion[i] = false;
            cnt[i] = 1;
        }
        ans = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i,edges,visited, inRecursion, cnt);
            }
        }
        

        return (ans == 0 ? -1 : ans);

        


        
    }
}