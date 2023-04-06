// ����494 Ŀ���
/*
 * ˼·����:էһ�����ܻ��뵽�û��ݣ����ǻ��ݳ�ʱ��״̬�ռ�̫��
 * ��������ѧ��������nums[]��target����nums[]ÿ��ǰ���+-�������target
 * ����Ӻź�Ϊx,���ź�Ϊsum-x,
 * �� x-(sum-x)=target
 * �� sum+target=x*2
 * 
 * ���ų�һЩ���: 
 * ���1: (sum+target)%2!=0�������ڽⷨ
 * ���2: abs(target) > sum �����ܷ���
 * 
 * ʵ���Ͼ�ת��Ϊ�˴�weightΪnums[]�������У�����capacityΪx�ı���
 * dp����: dp[j] ����j�ж����ַ�����һά���飩
 * ���ƹ�ʽ: dp[j] = dp[j]+dp[j-nums[i]];
 * ��������j�Ӻ���ǰ����ֹһ�����ַ�����Ӽ���
 */
class Solution {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
        }
        if(Math.abs(target)>sum)
            return 0;
        if((sum+target)%2==1)
            return 0;
        int x = (sum+target)/2;
        int dp[] = new int [x+1];
        dp[0] = 1;
        for(int i=0; i<nums.length; i++){
            for(int j= x; j>=nums[i]; j--){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[x];
    }

    public static void main(String[] args){
        int[] nums ={1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums,target));
    }
    
}