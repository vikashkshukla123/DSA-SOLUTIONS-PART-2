class Solution {
    public String maxSumOfSquares(int num, int sum) {

        StringBuilder digitToUse = new StringBuilder();
        while(digitToUse.length() < num){
            int val = Math.min(9,sum);
            digitToUse.append(val);
            sum = sum - val;
        }

       if(sum > 0) return "";
       return digitToUse.toString();
        


        
    }
}