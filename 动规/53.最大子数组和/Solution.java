// ����53 ����������
// ˼·��������һ�����������飬������������Ԫ��֮�����������������������������������Ҳ�и�������ΪҪ�������������ټ�Ԫ��ʱ��Ҫ����Ԫ���Ƿ�Ϊ��
// Ӧ�ü����Ѿ������Ԫ�غͣ����Ƿ��ܼ��뵽��������
// dp����: dp[i] ��i��β����������������
// ���ƹ�ʽ: dp[i-1] > 0,  dp[i] = dp[i-1]+nums[i]
// dp[i-1] <= 0 , dp[i] = nums[i];
// ��ʼ��: dp[0] = nums[0] 
public class Solution {
    // �ų��� + dp
    public static int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length+1];
        if(nums[0] > 0){
            dp[0] = nums[0];
        }else{
            dp[0] = 0;
        }
        int ans = dp[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(0,dp[i-1]+nums[i]);
            max = Math.max(nums[i],max);
            ans = Math.max(dp[i],ans);
        }
        return max>0? ans:max;
    }
    // ��dp
    public static int maxSubArray2(int[] nums) {
        int dp[] = new int[nums.length];
        int ans = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1]+nums[i];
            }else{
                dp[i] = nums[i];
            }
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums1));
    }
}