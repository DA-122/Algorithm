// ����377 ����ܽ�
// ˼·������էһ������ȫ�������⣬���Ǵ���Ҫ��ͬ���б���Ϊ��ͬ��ϣ�Ҳ���漰����������
// һ��������������Ʒ��������㣬�������������  //������ÿ��������˭��˭��
// ���������෴���������������ڲ������Ʒ // ÿ����������С��������һ��
public class Solution {
    public static int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int i = 0; i <= target ;i++){
            for(int j = 0; j < nums.length; j++){
                if(i >= nums[j]){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
    public static void main(String[] args){
        int[] nums = {1,2,3};
        int target=4;
        System.out.println(combinationSum4(nums,target));
    }
}
