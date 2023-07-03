// 力扣215. 数组中的第K个最大元素
// 思路分析：1. 最小堆
// 2. 快排

import java.util.PriorityQueue;
public class Solution{
    public static void main(String[] args){
        S solution = new S();
        int [] nums = {3,2,3,1,2,4,5,5,6};
        solution.findKthLargest2(nums,4);
    }
}


class S {
    public int findKthLargest(int[] nums, int k) {
        // 最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            heap.offer(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            if(nums[i] > heap.peek()){
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.poll();
    }

    // 快排 --- 部分排
    public int findKthLargest2(int[] nums, int k) {
        int pos = nums.length - k;
        // 第k大，下表是nums.length-k
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = quickSort(nums, left, right);
            if(mid > pos){
                right = mid - 1;
            }else if(mid < pos){
                left = mid + 1;
            }else{
                break;
            }
        }
        return nums[pos];
    }
    // 排一次
    public int quickSort(int [] nums, int start, int end){
        int pivot = nums[start];
        int left = start;
        int right = end;
        while(left < right){
            while(left < right && nums[right] > pivot){
                right--;
            }
            if(left < right){
                nums[left++] = nums[right];
            }
            while(left < right && nums[left] < pivot){
                left++;
            }
            if(left < right){
                nums[right--] = nums[left];
            }
        }
        nums[left] = pivot;
        return left;
    }
}
