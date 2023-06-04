//剑指13. 机器人的运动范围
// 思路分析：BFS
// 注意审题：是数位之和

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int movingCount(int m, int n, int k) {
        int result = 1;
        Deque<int []> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
         // 代表右 左 下 上
        int[][] pos = {{0,1},{0,-1},{1,0},{-1,0}};
        int[] start = {0,0};
        queue.offer(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int [] curPos = queue.poll();
                for(int j = 0 ; j < pos.length; j++){
                    int curX = pos[j][0] + curPos[0];
                    int curY = pos[j][1] + curPos[1];
                    if(get(curX) + get(curY) <= k && curX >=0 && curX < m && curY >= 0 && curY < n && !visited[curX][curY]){
                        queue.offer(new int[]{curX,curY});
                        visited[curX][curY] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
    public static int get(int num){
        int sum = 0;
        while(num > 0){
            sum+=num%10;
            num/=10;
        }
    
        return sum;
    }
    public static void main(String [] args){
        int m = 11, n = 8, k = 16;
        movingCount(m, n, k);
    }

}