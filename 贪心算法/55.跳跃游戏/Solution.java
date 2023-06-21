// ����55.��Ծ��Ϸ
// ˼·������̰�ģ�ÿ���������������λ��

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // ̰�Ľ� - ���ӵ�һ���±����ܵ������Զλ��
    public static boolean canJump(int[] nums) {
        // ���λ��
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