class Solution {
public:
int min(int a, int b){
    if(a < b) return a;
    return b;
}
    string digitSum(string s, int k) {
        if(s.length() <= k) return s;
        int n = s.length();
        string ans = s;
        string res = "";
        int idx = 0;
        while(true){
          int sum = 0;
          int targetIdx = idx + k;
          for(int i = idx ; i < min(ans.length(),targetIdx); i++){
              sum += ans[i] - '0';
          }
          res += to_string(sum);

          idx = targetIdx;

          if(idx >= ans.length()){
            ans = res;
            idx = 0;
            


            if(res.length() <= k){
                break;
            }

            res.clear();
          } 
          

        }
    return res;
        
    }
};