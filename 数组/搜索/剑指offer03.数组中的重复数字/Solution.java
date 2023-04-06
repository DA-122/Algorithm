import java.util.HashSet;
import java.util.Set;

// 剑指03 数组中的个重复数字
// 思路分析：1.哈希表 空间复杂度O(N)，时间复杂度O(N)
// 2. 原地交换, 时间复杂度O(N),空间复杂度O(1)
public class Solution{
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }else{
                set.add(nums[i]);
            }
        }
        return -1;
    }
    //从0开始，将每个位置上的数字交换到他本来应该在的位置上，
    //(1) 如果数字就在原应该在的位置上，跳过 nums[i] = i，    
    //(2) 数字等于原位置的数字，则找到重复数字 nums[i]!=i nums[nums[i]] = nums[i]
    //(3) 上述情况都不是的话 交换nums[i] 到第nums[i]位置上去
    // 注意只有在第一种情况会i++，真的找到了i位置上的数字
    public static int findRepeatNumber2(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i])
                return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
        System.out.print(findRepeatNumber2(nums));
    }
}