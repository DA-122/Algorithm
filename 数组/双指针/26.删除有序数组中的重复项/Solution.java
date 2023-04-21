// ����26.ɾ�����������е��ظ���
// ˼·������˫ָ��
public class Solution{
    public static int removeDuplicates(int[] nums) {
        // һ��һ��Ų��
        
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left < right){
            // �������ظ�Ԫ��
            if(nums[left] == nums[left+1]){
                int pivot = left + 1;
                int base = left + 1;
                while(pivot < right && nums[pivot] == nums[pivot+1]){
                    // �ظ�����
                    pivot++;
                }
                int differ = pivot -left;
                while(base + differ <= right){
                    nums[base] = nums[base + differ];
                    base++;
                }
                left++;
                right -= differ;
            }else{
                left++;
            }
        }
        return right+1;
    }

    // �򵥷���
    public static int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }
}