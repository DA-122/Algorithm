// 力扣1091.二进制矩阵中的最短路径
// 思路分析：BFS 注意防止走回头路
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1){
            return -1;
        }
        if(grid.length == 1){
            return 1;
        }
        int n = grid.length;
        boolean visited[][] = new boolean[n][n];
        visited[0][0] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        int curX = 0;
        int curY = 0;
        int result = 0;
        queue.offer(new int[]{0,0});
        // 向右 向左 向下 向上， 左上 右上 左下 右下
        int[][] pos = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}}; 
        while(!queue.isEmpty() && !(curX == n-1 && curY == n-1)){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int [] arr = queue.poll();
                curX = arr[0];
                curY = arr[1];
                for(int j = 0; j < pos.length; j++){
                    int x = curX + pos[j][0];
                    int y = curY + pos[j][1];
                    // 满足条件
                    if(x >=0 && x < n && y >=0 && y<n){
                        if(!visited[x][y]&&grid[x][y] == 0){
                            queue.add(new int[]{x,y});
                            visited[x][y] = true;
                        }
                    }
                }
            }
            result++;
        }
        if(curX!= n-1 || curY!=n-1){
            result = -1;
        }
        return result;
    }
    public static void main(String[] args){
        int [][] grid = {{0,1,0,0,0},{0,1,0,0,0},{0,0,0,0,1},{0,1,1,1,0},{0,1,0,0,0}};
        shortestPathBinaryMatrix(grid);
    }
}
