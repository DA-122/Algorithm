// 力扣213. 打家劫舍Ⅱ
// 思路分析：所有房子成了一个环形，也就是说第一栋房子和最后一栋房子不能同时被偷
// 可以分解为比较[0,i-2]和[1,i-1]两个区间上的打家劫舍
// 可以使用两个dp数组来解决问题
public class Solution {
    public static int rob(int[] nums) {
        if(nums.length < 2)
            return nums[0];
        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];
        dp1[0] = 0;
        dp1[1] = nums[0];
        dp2[0] = 0;
        dp2[1] = nums[nums.length-1]; 
        for(int i = 2; i < dp1.length;i++){
            dp1[i] =Math.max(dp1[i-2]+nums[i-1],dp1[i-1]);
            dp2[i] =Math.max(dp2[i-2]+nums[nums.length-i],dp2[i-1]);
        }
        return Math.max(dp1[nums.length-1],dp2[nums.length-1]);
    }   
    public static void main(String[] args){
        int [] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
