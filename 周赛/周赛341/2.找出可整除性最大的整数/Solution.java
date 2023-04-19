// 周赛341 找出可整除性最大的整数(Easy)
public class Solution{
    public static int maxDivScore(int[] nums, int[] divisors) {
        int ans[] = new int[2];
        for(int i = 0; i < divisors.length; i++){
            int score = divScore(nums,divisors[i]);
            if(score > ans[1]){
                ans[1] = score;
                ans[0] = i;
            }
        }
        return divisors[ans[0]];
    }
    public static int divScore(int[] nums, int target){
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%target == 0){
                num++;
            }
        }
        return num;
    }
    public static void main(String[] args){
        int[] nums = {4,7,9,3,9};
        int[] divisors = {5,2,3};
        maxDivScore(nums, divisors);
    }
}