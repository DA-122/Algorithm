// 力扣75.颜色分类（荷兰国旗问题）
// 思路分析：原地排序（两次遍历即可）
// 1. 第一次遍历把0换到头部，第二次遍历，把2换到尾部
// 2. 一次遍历


public class Solution {
    // 两次遍历
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, right = n -1;
        while(left < right){
            while(left < right && nums[left] == 0){
                left++;
            }
            while(left < right &&(nums[right] == 1 || nums[right] == 2)){
                right--;
            }
            if(left < right){
                nums[right] = nums[left];
                nums[left] = 0;
            }
        }
        right = n - 1; 
        while(left < right){
            while(left < right && nums[left] == 1){
                left++;
            }
            while(left < right && nums[right] == 2){
                right--;
            }
            if(left < right){
                nums[right] = nums[left];
                nums[left] = 1;
            }
        }
    }
    // 一次遍历

}