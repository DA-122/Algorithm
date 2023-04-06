public class Solution{ 
    public static int completePack(int[] weights,int[] values,int capacity){
        int[] dp = new int[capacity+1];
        for(int i = 0; i < weights.length;i++){
            for(int j = 0; j <= capacity; j++){
                if(j >= weights[i])
                    dp[j] = Math.max(dp[j],dp[j-weights[i]]+values[i]);
            }
        }
        return dp[capacity];
    }
    public static void main(String[] args){
        int[] weights = {1,3,4};
        int[] values = {15,20,20};
        int capacity=4;
        System.out.println(completePack(weights,values,capacity));
    }
}