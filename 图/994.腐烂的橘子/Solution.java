// 力扣994.腐烂的橘子
// 思路分析：多源分层BFS问题，可以在一开始将所有的腐烂坐标加入队列，然后分层遍历；
// 注意，可能会出现连通分量没有腐烂的橘子，这里可以使用rot和total进行计数，最后比较是否所有的橘子都腐烂了来判断连通分量。

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution{
    public static void main(String[] args){
        S s = new S();
        int[][] grid  = {{2,1,1},{1,1,0},{0,1,1}};
        s.orangesRotting(grid);
    }
}

class S {
    int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]>  queue = new ArrayDeque<>();
        int minute = 0;
        int rot = 0;
        int total = 0;
        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    total++;
                    if(grid[i][j] == 2){
                        rot++;
                        queue.offer(new int[]{i,j});
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] pos = queue.poll();
                for(int j = 0; j < move.length; j++){
                    int curX = pos[0] + move[j][0];
                    int curY = pos[1] + move[j][1];
                    if(curX >=0 && curY >= 0 && curX < m && curY < n && grid[curX][curY] == 1){
                        queue.offer(new int[]{curX,curY});
                        grid[curX][curY] = 2;
                        rot++;
                    }
                }
            }
            // 队列不空说明进入下一层，minute++
            if(!queue.isEmpty()){
                minute++;
            }
        }
        return rot == total? minute:-1;
    }
}