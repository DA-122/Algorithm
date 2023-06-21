// 力扣55.跳跃游戏
// 思路分析：贪心，每次找能跳到的最大位置

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // 贪心解 - 求解从第一个下标所能到达的最远位置
    public static boolean canJump(int[] nums) {
        // 最大位置
        int max = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while(!queue.isEmpty()&&max < nums.length){
            int pos = queue.poll();
            for(int i = max + 1; i <= nums[pos]+pos; i++){
                queue.offer(i);
            }
            max = Math.max(max, nums[pos]+pos);

        }
        return max >= nums.length - 1;
    }
    public static void main(String args[]){
        int[] nums = {2,3,1,1,4};
        canJump(nums);
    }
}