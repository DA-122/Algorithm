// ����198 ��ҽ���
// ˼·��������nums.lenght��ѡ��͵�Խ����ߵļ��ң��Ҳ�������
// ����i��ʱ������ζ��i-1�Ҳ��ã�dp[i] = dp[i-2]+nums[i]
//           ������ζ��i-1�ҿ��ÿɲ���,ֻ��Ҫ��i-1����β������ dp[i] = dp[i-1]
// dp����,,����Ϊnums.length+1, dp[i]��ŵ���i��ʱ������͵�Ե������
// ���ƹ�ʽ dp[i] = max(dp[i-2]+nums[i],dp[i-1])
// ��ʼ��: dp[0] = 0, dp[1] = nums[0]
class Solution {
    public static int rob(int[] nums) {
        int[] values = new int [nums.length+1];
        values[0] = 0;
        values[1] = nums[0];
        for(int i = 2; i < values.length; i++){
            values[i] = Math.max(values[i-2]+nums[i-1 ] ,values[i-1]);
        }
        return values[nums.length];
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
     }
}