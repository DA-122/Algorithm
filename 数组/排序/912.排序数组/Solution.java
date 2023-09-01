// ¿ìÅÅ
class S {
    static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l - 1, j = r + 1, x = nums[l + r >> 1];
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}

public class Solution {
    public static void main(String[] args){
        int nums[] = {2,3,1,4,5,0};
        S solution = new S();
        solution.sortArray(nums);
    }
}