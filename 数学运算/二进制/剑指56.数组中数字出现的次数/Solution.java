// 剑指56.数组中数字出现的次数（要求时间复杂度O(n)，空间复杂度O(1)）
// 常规思路： 如果没有空间复杂度要求可以哈希表，时间O(n)，空间O(n) 或者排序加遍历时间O(nlogn)，空间O(1)
// 题解: 分组异或

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution{
    // 题解思路：如果除了一个数字以外，其他数字都出现了两次，那么如何找到出现一次的数字？
    // 答案：全员异或，成对出现的数字异或为0，最终异或结果就是出现一次的那个数字。
    // 区别：但是这里有两个出现一次的数字，可以将所有数字进行分组，
    // 1. 分成两组并保证两个只出现一次的数字在不同的组中
    // 2. 保证相同的数字被分到一组中去。
    // 核心问题就变为了如何分组
    // 假设两个出现一次的数字分别为a和b，且a^b = x
    // 将x转化为二进制形式， X(i)X(i-1).....X(0)
    // X(i)可以是1或者0，X(i) = 1, a,b第i位不同; X(i) =0, a,b第i位同 
    // 可以随意取一位x(i) = 1, 对于所有的数字来说，其x(i)位非0即1
    // 可以将x(i)位是0的放入一组，X(i)位是1的放入另一组，就完成了这个分组

    public static int[] singleNumbers(int[] nums) {
        int ans[] = new int[2];
        int x = nums[0];
        
        // 取得最终的异或
        for(int i = 1 ; i < nums.length; i++){
            x ^=nums[i];
        }
        // 右移位数
        int counter = 0;
        while(x > 0){
            int y = (x>>counter)&1;
            if(y == 1){
                break;
            }else{
                counter++;
            }
        }
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++){
             if(((nums[i]>>counter)&1) == 0){
                left.add(nums[i]);
             }else{
                right.add(nums[i]);
             }
        }
        ans[0] = left.get(0);
        ans[1] = right.get(0);
        for(int i = 1; i < left.size(); i++){
            ans[0] ^= left.get(i);
        }
        for(int i = 1; i < right.size(); i++){
            ans[1] ^= right.get(i);
        }
        
        return ans;
    }


    // 常规思路: 排序加遍历 时间O(nlogn)，空间O(1)
    public static int[] singleNumbers2(int[] nums) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        int pivot = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                i++;
            }else{
                ans[pivot] = nums[i];
                pivot++;
            }
        }
        if(pivot == 1){
            ans[pivot] = nums[nums.length-1];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {6,5,5,9,10,9,4,10};
        singleNumbers(nums);

    }
}