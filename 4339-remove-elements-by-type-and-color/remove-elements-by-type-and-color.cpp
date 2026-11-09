class Solution {
public:
bool notSame(int type, int color, vector<int>&toCheck){
    if(type != toCheck[0] || color != toCheck[1]){
        return true;
    }


    return false;
}
    bool canRemoveAll(vector<int>& types, vector<int>& colors, vector<int>& groupSize) {
        int n = types.size();
        int m = groupSize.size();
        stack<vector<int>>st;
        for(int i = 0; i < n; i++){
            if(groupSize[types[i]] == 1) continue;
            if(st.empty() || notSame(types[i],colors[i],st.top())){
                st.push({types[i],colors[i],1});
                continue;
            }else{
                vector<int>prev = st.top();
                int cnt = prev[2];
                int newCnt = 1 + cnt;
                st.pop();

                if(groupSize[types[i]] == newCnt){
                    continue;
                }else{
                    st.push({prev[0],prev[1],newCnt});
                }
            }
            

            




        


        }

        return st.empty();
        
    }
};