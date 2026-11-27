class Solution {
    int reverse(int val){
        int ans = 0;
        while(val != 0){
            int num = val % 10;
            ans = ans * 10 + num;
            val = val / 10;
        }

        return ans;
    }
    public boolean isSameAfterReversals(int num) {
        int reverseOne = reverse(num);
        int reverseTwo = reverse(reverseOne);

        return (reverseTwo == num);
    }
}