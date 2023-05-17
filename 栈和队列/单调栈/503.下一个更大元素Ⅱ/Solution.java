// 503 下一个更大元素Ⅱ
// 题目分析:nums变成了循环数组
// 思路分析：单调栈+哈希表  迭代条件变化，迭代到stack为空或第二次迭代到stack.peek。 哈希表防止重复进栈
//  


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;


public class Solution{
    public static void main(String[] args){
        int []nums = {1,2,1};
        System.out.println(nextGreaterElements(nums));
    }
    public static int[] nextGreaterElements(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        stack.push(i);
        i = (i+1)%n;
        while(!stack.isEmpty()){
            if(nums[i] <= nums[stack.peek()]){
                if(!set.contains(i)){
                    stack.push(i);
                    set.add(i);
                }
            }else{
                while(!stack.isEmpty()&& nums[i] > nums[stack.peek()]){
                    res[stack.peek()] = nums[i];
                    stack.pop();
                }
                if(!stack.contains(i)){
                    stack.push(i);
                    set.add(i);
                }
            }
            i = (i+1)%n;
            if(i==stack.peek()){
                break;
            }
        }
        while(!stack.isEmpty()){
            res[stack.pop()] =-1;
        }
        return res;
    }
}