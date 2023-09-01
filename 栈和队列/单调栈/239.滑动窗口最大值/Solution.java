// 239.滑动窗口最大值
// 思路分析：
// 1. 堆方法，维护一个大根堆，先把前k个元素入堆，每次移动窗口，比较堆根下标是否在滑动窗口内，如果不在，就出堆直到满足条件。 时间复杂度O(nlogn) 空间复杂度O(n)
// 2. 单调栈，栈内元素非递增，每次滑动都调整单调栈
// 3. 分块+预处理
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution{
    // 构建大根堆
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[]res = new int[n - k + 1];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> (b[0] - a[0]));
        for(int i = 0; i < k; i++){
            heap.offer(new int[]{nums[i], i});
        }
        res[0] = heap.peek()[0];
        for(int i = k; i < n; i++){
            heap.offer(new int[]{nums[i], i});
            while(!heap.isEmpty()&&heap.peek()[1] <= i - k){
                heap.poll();
            }
            res[i-k+1] = heap.peek()[0];
        }
        return res;
    }

    
    // 单调栈解法
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                stack.pop();
            }
            stack.push(i);
         }
         res[0] = nums[stack.peekLast()];
         for(int i = k; i < nums.length; i++){
             if(stack.peekLast() == i - k){
                 stack.pollLast();
             }
             while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                 stack.pop();
             }
             stack.push(i);
             res[i - k + 1] = nums[stack.peekLast()];
         }
         return res;

     }
    public static void main(String[] args){
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow2(nums, k);
    }
}