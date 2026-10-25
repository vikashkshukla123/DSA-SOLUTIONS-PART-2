class Solution {
    public int calculateScore(int a, int b) {
        int cnt1 = 0;
        int cnt2 = 0;
        for(int bit = 0; bit <= 15; bit++){
           int bitVal = (1 << bit) & a;
           if(bitVal != 0){
            cnt1++;
           }

            int bitVal2 = (1 << bit) & b;
            if(bitVal2 != 0){
                cnt2++;
            }
        }
        if(cnt1 >= cnt2) return (cnt1 * cnt2);
        return cnt2 / cnt1;
    }
}