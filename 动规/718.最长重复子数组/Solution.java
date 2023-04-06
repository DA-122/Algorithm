// ����718 �����������
// ˼·������
// dp���� dp[i][j] text1��i���ַ���text2��j���ַ�ǰ���������������
// ���ƹ�ʽ: text1[i] = text2[j] dp[i][j] = dp[i-1][j-1]
// text1[i] != text2[j] dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j])
// ����������Ȼǰ���� 
public class Solution {
    // ���������Ż�
    public static int findLength2(int[] nums1, int[] nums2) {
        int ans = 0;
        int[] dp = new int[nums2.length+1];
        for(int i = 0; i < nums1.length; i++){
            for(int j = nums2.length; j > 0; j--){
                if(nums1[i] == nums2[j-1]){
                    // ��ֹ���ǣ�jҪ�Ӻ���ǰ
                    dp[j] = dp[j-1]+1;  
                    ans = Math.max(ans,dp[j]);
                }else{
                    dp[j] = 0;
                }
            }
        }
        return ans;
    }
    // ��άdp����
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