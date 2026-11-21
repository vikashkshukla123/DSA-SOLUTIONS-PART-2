class Solution {
public:
void solve(int node, string &s,vector<int>&parent, vector<int>&lastSeen,vector<int>&size,unordered_map<int,vector<int>>&adj,vector<bool>&visited){
    visited[node] = true;
    char ch = s[node];
    int nodeAncestor = lastSeen[ch - 'a'];
    lastSeen[ch - 'a'] = node;
    for(auto &ngbr : adj[node]){
        if(!visited[ngbr]){
            solve(ngbr, s, parent, lastSeen,size, adj,visited);
        }
    }
    lastSeen[ch - 'a'] = nodeAncestor;
    
    if(node != 0){
    int newParent = parent[node];
    if(nodeAncestor != -1){
    newParent = nodeAncestor;

    }
    
    parent[node] = newParent;
    size[newParent] += size[node];

    }
}
    vector<int> findSubtreeSizes(vector<int>& parent, string s) {
        int n = s.length();
        vector<int>lastSeen(26,-1);
        vector<int>size(n,1);
        unordered_map<int,vector<int>>adj;
        vector<bool>visited(n,false);
        for(int i = 0; i < parent.size(); i++){
            adj[parent[i]].push_back(i);
        }
        solve(0,s,parent,lastSeen,size,adj,visited);


        return size;

        
    }
};