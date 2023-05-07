// ����45 ��Ծ��Ϸ
// ˼·������ BFS ̰��

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    // ˼·1. ���б���(BFS), �����ÿһ�����Ե���Ľڵ㣬���ɵõ����մ�
    // �ö��б���ÿһ���Ľڵ�
    public static int jump(int[] nums) {
        int n = nums.length;
        int jump[] = new int[n];
        Deque<Integer> queue = new LinkedList<>();
        // ��ʼ��1����λ��
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
    // ˼·2. ̰�ģ�ʵ�����ǵ�һ���汾�ļ򻯣� ֻ����ÿһ�����ܵ������Զ�߽�
    // ���Ӷ�O(N)
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
