// ����300 �����������
// dp���飺dp[i]��ʾ��iԪ�ؽ�β������������еĳ���
// ���ƹ�ʽ: dp[i] = dp[i-1]+1

public class Solution {
    public static int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        int max = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++;
            max = Math.max(dp[i],max);
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }
}