// ��ָ21.��������˳��ʹ����λ��ż��ǰ
// ��Ŀ����������λ��ż��ǰ���Ҳ��ܴ�С˳��
// ˼·������1. ˫ָ��leftָ����,rightָ���������ż�ֱ����������
// 2 ԭ�ؽ���
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