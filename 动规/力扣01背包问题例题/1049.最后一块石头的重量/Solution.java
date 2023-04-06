// 力扣1049 最后一块石头的重量
class Solution {
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i=0 ; i<stones.length;i++){
            sum+=stones[i];
        }
        int target = sum/2;
        int dp[] = new int [target + 1];
        for(int i = 0; i < target + 1; i++){
            if(i < stones[0])
                dp[i] = 0;
            else
                dp[i] = stones[0];
        }
        for(int i = 1 ; i < stones.length; i++){
            for(int j = target; j >=0; j--){
                if(j <  stones[i])
                    dp[j] = dp[j];
                else    
                    dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
            if(dp[target] == target)
                break;
        }
        return Math.abs(sum-2*dp[target]);
    }
    public static void main(String[] args){
        int [] testCase = {2,7,4,1,8,1};
        System.out.println(lastStoneWeightII(testCase));
    }
}