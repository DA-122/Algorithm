// 力扣718 最长公共子数组
// 思路分析：
// dp数组 dp[i][j] text1第i个字符和text2第j个字符前的最长公共序列数量
// 递推公式: text1[i] = text2[j] dp[i][j] = dp[i-1][j-1]
// text1[i] != text2[j] dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j])
// 遍历方向：显然前到后 
public class Solution {
    // 滚动数组优化
    public static int findLength2(int[] nums1, int[] nums2) {
        int ans = 0;
        int[] dp = new int[nums2.length+1];
        for(int i = 0; i < nums1.length; i++){
            for(int j = nums2.length; j > 0; j--){
                if(nums1[i] == nums2[j-1]){
                    // 防止覆盖，j要从后往前
                    dp[j] = dp[j-1]+1;  
                    ans = Math.max(ans,dp[j]);
                }else{
                    dp[j] = 0;
                }
            }
        }
        return ans;
    }
    // 二维dp数组
    public static int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i = 1; i < nums1.length+1; i++){
            for(int j = 1; j < nums2.length+1; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;  
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        findLength(nums1, nums2);
    }
}