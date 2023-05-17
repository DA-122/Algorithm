// 2441 ���Ӧ����ͬʱ���ڵ����������
// ˼·��������ϣ�� | ����+˫ָ��

import java.util.Arrays;

public class Solution{
    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left] < -nums[right]){
                left++;
            }else if(nums[left] > -nums[right]){
                right--;
            }else{
                return nums[right];
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int nums[] = {-1,2,-3,3};
        findMaxK(nums);
    }
}