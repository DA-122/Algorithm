class Solution {
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            while(a / 10 > 0){
                a = a /10;
            }
            for(int j = i + 1; j < nums.length; j++){   
                int b = nums[j] % 10;
                int max = Math.max(a,b);
                int min = Math.min(a,b);
                if(gcd(max,min) == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public int gcd(int a, int b){
        int c = a % b;
        return gcd(b, c);
    }
}