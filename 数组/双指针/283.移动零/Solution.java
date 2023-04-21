// 力扣283. 移动零
// 思路： 双指针
public class Solution{
    // 两次遍历，第一次遍历找到非0元素，并且依次放置到数组左侧，数组剩余部分填充0
    public void moveZeroes(int[] nums) {
        if(nums == null)
            return;
        // 记录非零元素个数
        int j = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i]!=0){
                // 非零元素放置到数组左侧
                nums[j++] = nums[i];
            }
        }
        // 剩余数组填充零
        for(int i = j; j < nums.length; i++){
            nums[i] = 0;
        }
    }
    // 快排思想,先找到第一个0，然后从第一个0开始，如果有非0元素就和第一个0交换
    public void moveZeroes2(int[] nums) {
        if(nums == null)
            return;
 		//两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            // j 相当于是指向为0的元素
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}