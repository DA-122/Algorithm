// 力扣1035 不相交的线
// 思路分析：不能交叉说明有顺序，相等可画线，类比1143 最长公共子序列
// 复杂度 时间O(MN) 空间O(MN)
public class Solution {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i = 1; i < nums1.length+1; i++){
            for(int j =1; j< nums2.length+1; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
    public static void main(String[] args){
        int[] nums1 = {1,4,2};
        int[] nums2 = {1,2,4};
        System.out.println(maxUncrossedLines(nums1, nums2));
    }
}
