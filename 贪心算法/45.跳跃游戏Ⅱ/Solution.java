// 力扣45 跳跃游戏
// 思路分析： BFS 贪心

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    // 思路1. 队列遍历(BFS), 计算出每一跳可以到达的节点，即可得到最终答案
    // 用队列保存每一跳的节点
    public static int jump(int[] nums) {
        int n = nums.length;
        int jump[] = new int[n];
        Deque<Integer> queue = new LinkedList<>();
        // 初始化1跳的位置
        for(int i = 1; i <= nums[0]&& i < n; i++){
            queue.offer(i);
            jump[i] = 1;
        }
        while(!queue.isEmpty()&&jump[n-1] == 0){
            int curPos = queue.poll();
            for(int i = curPos+1; i <= curPos + nums[curPos]&& i < n; i++){
                if(jump[i] ==0){
                    queue.offer(i);
                    jump[i] = jump[curPos]+1;
                }
            }
        }
        return jump[n-1];
    }
    // 思路2. 贪心（实际上是第一个版本的简化） 只考虑每一步所能到达的最远边界
    // 复杂度O(N)
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0; 
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]); 
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public static void main(String[] args){
        int [] nums = {1,1,1,1};
        System.out.println(jump(nums));
    }
}
