class Solution {
    int mod = 1000000007;
    long hcf(long a, long b){
        if(b == 0){
            return a;
        }

        return hcf(b, a % b);
    }
    long lcm(long a, long b){
        return (a /hcf(a,b)) * b;
    }
    boolean isNthMagical(long mid, long n, long a, long b){
        long n1 = mid / a;
        long n2 = mid / b;

        long n3 = mid / lcm(a,b);


        if(n1 + n2 - n3 >= n){
            return true;
        }
        return false;
    }
    public int nthMagicalNumber(int n, int a, int b) {
        long low = Math.min(a,b);
        long high = n * low;
        long ans = 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(isNthMagical(mid,n,a,b)){
                ans = mid;
                high = mid - 1;

            }else{
                low = mid + 1;
            }

        }

        return (int)(ans % mod);
    }
}