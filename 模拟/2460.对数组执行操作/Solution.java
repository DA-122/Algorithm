// ����2460. ������ִ�в���
// ˼·��������ģ��
public class Solution {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int pivot = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
            if(nums[i] != 0){
                res[pivot++] = nums[i];
            }
        }
        res[pivot++] = nums[nums.length-1];
        return res;
    }
}
