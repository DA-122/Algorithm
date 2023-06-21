// ����75.��ɫ���ࣨ�����������⣩
// ˼·������ԭ���������α������ɣ�
// 1. ��һ�α�����0����ͷ�����ڶ��α�������2����β��
// 2. һ�α���


public class Solution {
    // ���α���
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
    // һ�α���

}