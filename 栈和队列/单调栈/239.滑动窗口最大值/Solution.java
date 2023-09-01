// 239.�����������ֵ
// ˼·������
// 1. �ѷ�����ά��һ������ѣ��Ȱ�ǰk��Ԫ����ѣ�ÿ���ƶ����ڣ��Ƚ϶Ѹ��±��Ƿ��ڻ��������ڣ�������ڣ��ͳ���ֱ������������ ʱ�临�Ӷ�O(nlogn) �ռ临�Ӷ�O(n)
// 2. ����ջ��ջ��Ԫ�طǵ�����ÿ�λ�������������ջ
// 3. �ֿ�+Ԥ����
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution{
    // ���������
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

    
    // ����ջ�ⷨ
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