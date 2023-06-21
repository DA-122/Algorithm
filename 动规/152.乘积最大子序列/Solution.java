// ����152.�˻����������
// ˼·��������̬�滮
// ��Ϊ�и�������ʹ������С����С�����
// �����Ҫά��һ����ά����

public class Solution {
    public int maxProduct(int[] nums) {
        int dp[][] = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i][0] = Math.max(dp[i-1][0]*nums[i],Math.max(nums[i],dp[i-1][1] * nums[i]));
            dp[i][1] = Math.min(dp[i-1][1]*nums[i],Math.min(nums[i],dp[i-1][0] * nums[i]));
        }
        int ans =  dp[0][0];
        for(int i = 1; i < nums.length; i++){
            ans = Math.max(ans,dp[i][0]);
        }
        return ans;
    }
    // ���������Ż�
    public int maxProduct2(int[] nums) {
        int maxVal = nums[0], minVal = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            int mx = maxVal, mn = minVal;
            maxVal = Math.max(mx*nums[i], Math.max(mn*nums[i],nums[i]));
            minVal = Math.min(mn*nums[i], Math.min(mx*nums[i],nums[i]));
            ans = Math.max(maxVal,ans);
        }
        return ans;
    }

}