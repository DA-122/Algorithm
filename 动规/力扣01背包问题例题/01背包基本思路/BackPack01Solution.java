public class BackPack01Solution {
    // 2维dp数组
    public static int backPack01dim1(int[] weights, int []values, int capacity){
        int [][] dp = new int [weights.length][capacity+1];
        for(int j = 0; j <= capacity; j++){
            if(j < weights[0]){
                dp[0][j] = 0;
            }else{
                dp[0][j] = values[0];
            }
        }
        for(int i = 1; i < weights.length; i++){
            for(int j = 0; j <= capacity; j++){
                if(j < weights[i]){
                    dp[i][j] = dp[i-1][j]; 
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+values[i]);
                }
            }
        }
        return dp[weights.length-1][capacity];
    }
    
    // 1维dp数组
    public static int backPack01dim2(int[] weights, int []values, int capacity){
        int [] dp = new int [capacity+1];
        for(int j = 0; j <= capacity; j++){
            if(j < weights[0]){
                dp[j] = 0;
            }else{
                dp[j] = values[0];
            }
        }
        for(int i = 1; i < weights.length; i++){
            for(int j = capacity; j >= 0; j--){
                if(j < weights[i]){
                    dp[j] = dp[j]; 
                }else{
                    dp[j] = Math.max(dp[j],dp[j-weights[i]]+values[i]);
                }
            }
        }
        return dp[capacity];
    }


    public static void main(String[] args ){
        int weights[] = {2,3,4,5};
        int values[] = {3,4,5,6};
        int capacity = 8;
        System.out.println(backPack01dim1(weights,values,capacity));
        System.out.println(backPack01dim2(weights,values,capacity));
    
    }
}
