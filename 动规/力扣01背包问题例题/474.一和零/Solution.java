// ÈÝÁ¿capacity m,n

public class Solution {
    public static int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int[m+1][n+1];
        for(int i = 0; i < strs.length; i++){
            int oneNum = getOneNum(strs[i]);
            int zeroNum = strs[i].length()-oneNum;
            for(int j = m; j>=0; j--){
                for(int k = n; k>=0; k--){
                    if(oneNum>k||zeroNum>j)
                        dp[j][k] = dp[j][k];
                    else    
                        dp[j][k] = Math.max(dp[j][k],dp[j-zeroNum][k-oneNum]+1);
                }
            }
        }   
        return dp[m][n];
    }
    public static void main(String[] args){
        String [] testCase =  {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(testCase, 5, 3));
    }
    public static int getOneNum(String str){
        int num = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='1'){
                num++;
            }
        }
        return num;
    }
}