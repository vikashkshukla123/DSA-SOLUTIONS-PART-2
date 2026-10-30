class Solution {
public:
typedef vector<int> v;
    int shortestPath(int n, vector<vector<int>>& edges, string labels, int k) {
        int m = edges.size();
        unordered_map<int,vector<vector<int>>>adj;
        for(int i =  0; i < m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj[u].push_back({v,wt});
        }

        priority_queue<v,vector<v>,greater<v>>pq;
        pq.push({0,0,1});
        vector<vector<int>>distCount(n,vector<int>(k+1,1e9));
        distCount[0][1] = 0;
        while(!pq.empty()){
            vector<int>values = pq.top();
            pq.pop();

            int wt = values[0];
            int node = values[1];
            int consecutive = values[2];

            if(distCount[node][consecutive] < wt) continue;

            if(node == n-1){
                return wt;
            }

            for(vector<int>&ngbr : adj[node]){

                int ngbr_node = ngbr[0];
                int ngbr_wt = ngbr[1];

                char label = labels[ngbr_node];

                if(label == labels[node] && consecutive + 1 > k){
                    continue;
                }

                int newCount = label == labels[node] ? consecutive + 1 : 1;


                if(wt + ngbr_wt < distCount[ngbr_node][newCount]){
                        distCount[ngbr_node][newCount] = wt + ngbr_wt;
                        pq.push({wt + ngbr_wt, ngbr_node, newCount});
                 }
                    
    







            }


            


        }


        
return -1;

        
    }
};