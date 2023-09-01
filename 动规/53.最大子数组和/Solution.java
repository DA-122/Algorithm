// ����53 ����������
// ˼·��������һ�����������飬������������Ԫ��֮�����������������������������������Ҳ�и�������ΪҪ�������������ټ�Ԫ��ʱ��Ҫ����Ԫ���Ƿ�Ϊ��
// Ӧ�ü����Ѿ������Ԫ�غͣ����Ƿ��ܼ��뵽��������
// dp����: dp[i] ��i��β����������������
// ���ƹ�ʽ: dp[i-1] > 0,  dp[i] = dp[i-1]+nums[i]
// dp[i-1] <= 0 , dp[i] = nums[i];
// ��ʼ��: dp[0] = nums[0] 
public class Solution {
    // dp ���Կ��� dp[i] ֻ�� dp[i-1] �й�
    public static int maxSubArray2(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int dp[] = new int[n+1];
        for(int i = 1; i < n + 1; i++){
            dp[i] = Math.max(dp[i-1]+ nums[i-1], nums[i-1]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    // ���������Ż�
    public int maxSubArray3(int[] nums) {
        int n = nums.length;
        int pre = nums[0];
        int res = pre;
        for(int i = 1; i < n; i++){
            pre = Math.max(pre + nums[i], pre);
            res = Math.max(pre,res);
        }
        return res;
    }


    public static void main(String[] args){
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums1));
    }
}