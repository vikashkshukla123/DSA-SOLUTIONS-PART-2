class Solution {
public:
int solve(int node, vector<int>&ops, vector<int>&score, unordered_map<int,vector<int>>&adj,vector<bool>&visited){
    visited[node] = true;
    int mini = 1e9;
    int totalSum = 0;
    for(auto &ngbr : adj[node]){
        if(!visited[ngbr]){

             int val = solve(ngbr,ops,score,adj,visited);
             mini = min(mini,val);
             totalSum += val;
        }
    }

    if(mini == 1e9) return score[node];
    if(ops[node] == 0 && mini < 0 || ops[node] == 1){
        return totalSum + score[node] - mini;
    }

    return totalSum + score[node];

}

    int maxScore(vector<int>& parent, vector<int>& op, vector<int>& score) {
        unordered_map<int,vector<int>>adj;
        int n = parent.size();
        for(int i = 1; i < n; i++){
            adj[parent[i]].push_back(i);
        }
        vector<bool>visited(n,false);
        return solve(0,op,score,adj,visited);
        
    }
};