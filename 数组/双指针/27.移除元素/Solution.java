// ����27 �Ƴ�Ԫ��
// ˼·������Ҫ��ռ临�Ӷ�O(1)��ԭ���޸����飬���˫ָ��

public class Solution{
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int right = n-1;
        int left = 0;
        while(left <= right){
            if(nums[left] != val){
                left++;
            }else{
                for(int i = left; i < right; i++){
                    nums[i] = nums[i+1];
                }
                right--;
            }
        }
        return right+1;
    }
    public static void main(String[] args){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        removeElement(nums, val);
    }
}