// 剑指21.调整数组顺序使奇数位于偶数前
// 题目分析：奇数位于偶数前，且不管大小顺序
// 思路分析：1. 双指针left指针增,right指针减，将奇偶分别加入数组中
// 2 原地交换
public class Solution{
    public static int[] exchange(int[] nums) {
        int[] ans  = new int[nums.length];
        int left = 0, right = nums.length-1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] %2 == 1){
                ans[left++] = nums[i];
            }else{
                ans[right--] = nums[i];
            }
        }
        return ans;
    }
    public static int [] exchange2(int[] nums){
        int left = 0, right = nums.length-1;
        while(left < right ){
            while(nums[left] %2 ==1 && left < right){
                left++;
            }
            while(nums[right] %2 ==0 && left < right){
                right--;
            }
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
    public static void main(String[] args){
        int [] nums = {1,2,3,4};
        int [] ans = exchange(nums);
        int [] ans2 = exchange2(nums);
        for(int num: ans2){
            System.out.print(num+",");
        }
    }
}