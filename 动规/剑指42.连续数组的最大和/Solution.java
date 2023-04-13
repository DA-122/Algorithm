// 剑指42 和力扣53完全一致
public class Solution{
    public static int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];
        int max = nums[0];
        sums[0] = nums[0];
        for(int i = 1; i < sums.length; i++){
            if(sums[i-1] < 0){
                sums[i] = nums[i];
            }else{
                sums[i] = nums[i] + sums[i-1];
            }
            max = Math.max(sums[i],max);
        }
        return max;
    }
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }
}