// 力扣167 两数之和 有序情况
// 思路： 无序：哈希表 时间复杂度O(n) 空间复杂度O(n)
// 有序： 双指针 时间复杂度O(n) 空间复杂度O(1)

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right =  n - 1;
        int [] res = {left , right};

        while(left < right){
            if(numbers[left] + numbers[right] < target){
                left++;
            }else if(numbers[left] + numbers[right] > target){
                right--;
            }else{
                res[0] = left+1;
                res[1] = right+1;
                break;
            }
        }
        return res;
 
    }
}