// ��ָoffer14 ������
// ˼·��������̬�滮
// dp����: ��nΪֹ���и�����˻�
// dp[i] = max(max(dp[i-j],i-j)*max(dp[j],j))
// ��������ǰ����
public class Solution{
    public static int cuttingRope(int n) {
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 2; i < nums.length; i++){
            nums[i] = 0;
            for(int j = 1; j <= i/2; j++){
                nums[i] = Math.max(nums[i],Math.max(nums[i-j],i-j)*Math.max(nums[j],j));
            }
        }
        return nums[n];
    }
    public static void main(String[] args){
        System.out.println(cuttingRope(3));
    }
}
