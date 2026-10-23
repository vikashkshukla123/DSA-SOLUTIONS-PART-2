class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean isSorted = true;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) < s.charAt(i-1)){
                isSorted = false;
                break;
            }
        }
        if(isSorted) return 0;
        if(n == 2) return -1;
        int mini = s.charAt(0);
        int maxi = s.charAt(0);
        for(int i = 0; i < n; i++){
            mini = Math.min(mini,s.charAt(i));
            maxi = Math.max(maxi,s.charAt(i));
        }

        if(mini == s.charAt(0) || maxi == s.charAt(n-1)) return 1;

        int secondMini = s.charAt(1);
        int secondMaxi = s.charAt(1);

        for(int i = 1; i <= n-2; i++){
            secondMini = Math.min(secondMini, s.charAt(i));
            secondMaxi = Math.max(secondMaxi, s.charAt(i));
        }

        if(s.charAt(0) > secondMaxi && secondMini > s.charAt(n-1)){
            return 3;
        }else{
            return 2;
        }
        

    }
}