// 力扣1031 两个非重叠子数组的最大和
// 思路分析：两个dp数组分别记录两个子数组的和，然后以一个为基准，遍历

public class Solution{

    // dp + 遍历
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        // 初始化
        for(int i = 0; i < firstLen; i++){
            dp1[firstLen-1] +=nums[i];
        }
        for(int i = firstLen; i <nums.length; i++){
            dp1[i] = dp1[i-1] + nums[i] -nums[i-firstLen]; 
        }
        // 初始化
        for(int i = 0; i < secondLen; i++){
            dp2[secondLen-1] +=nums[i];
        }
        for(int i = secondLen; i <nums.length; i++){
            dp2[i] = dp2[i-1] + nums[i] -nums[i-secondLen]; 
        }
        int max = 0;
        for(int i = secondLen-1 ; i < nums.length; i++){
            if(i + 1 - secondLen >= firstLen){
                for(int j = firstLen - 1; j < i+1-secondLen; j++)
                    max =Math.max(max,dp2[i]+dp1[j]);
            }
            if(nums.length - secondLen >= firstLen){
                for(int j = i + firstLen; j < nums.length; j++)
                    max =Math.max(max,dp2[i]+dp1[j]);
            }
        }
        return max;
    }

}