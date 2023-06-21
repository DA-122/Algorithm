// ����200 ��������
// ˼·������ͼ�㷨

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean visited [][] = new boolean[m][n];
        Deque<int []> queue = new ArrayDeque<>();
        // ���������ĸ�����
        int pos[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // δ���ʹ����Դ�Ϊ���
                if(grid[i][j] == '1' && !visited[i][j]){
                    result++;
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] curPos = queue.poll();
                        for(int k = 0; k < pos.length; k++){
                            int x = curPos[0] + pos[k][0];
                            int y = curPos[1] + pos[k][1];
                            // �ڱ߽��ڲ���δ���ʲ����ǵ���
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