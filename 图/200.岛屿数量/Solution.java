// 力扣200 岛屿数量
// 思路分析：图算法

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visited [][] = new boolean[m][n];
        Deque<int []> queue = new ArrayDeque<>();
        // 上下左右四个方向
        int pos[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // 未访问过，以此为起点
                if(grid[i][j] == '1' && !visited[i][j]){
                    result++;
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] curPos = queue.poll();
                        for(int k = 0; k < pos.length; k++){
                            int x = curPos[0] + pos[k][0];
                            int y = curPos[1] + pos[k][1];
                            // 在边界内并且未访问并且是岛屿
                            if(0 <= x && x < m && 0 <=y && y<n && !visited[x][y] && grid[x][y]=='1'){
                                visited[x][y] = true;
                                queue.offer(new int[]{x,y});
                            }                        
                        }
                    }
                }
            }
        }
        return result;
    }
    public static void main(String args[]){
        char grid [][] = {{'1','1','1','1','0'},{'1','1','0','1','0'},
        {'1','1','0','0','0'},{'0','0','0','0','0'}};
        numIslands(grid);
    }
}