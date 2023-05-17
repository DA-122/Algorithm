// 239.滑动窗口最大值
// 思路分析：单调栈，栈内元素非递增，每次滑动都调整单调栈

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution{
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1){
            return nums;
        }

        int[] ans =new int[nums.length - k + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums[0]);
        for(int i = 1; i < k; i++){
            if(nums[i] > stack.peek()){
                while(!stack.isEmpty()&&stack.peek() < nums[i]){
                    stack.pop();
                }
                stack.push(nums[i]);
            }else{
                stack.push(nums[i]);
            }
        }
        ans[0] = stack.getLast();
        for(int i = k; i < nums.length; i++){
            if(stack.getLast() == nums[i-k]){
                stack.removeLast();
            }
            // 调整单调栈
            if(nums[i] > stack.peek()){
                while(!stack.isEmpty()&&stack.peek() < nums[i]){
                    stack.pop();
                }
                stack.push(nums[i]);
            }else{
                stack.push(nums[i]);
            }
            ans[i-k+1] = stack.getLast();
        }
        return ans;
    }
    public static void main(String[] args){
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(nums, k);
    }
}