// 灰色 空地
// 绿色 基站
// 橙色 信号覆盖

// BFS问题
// 步骤：先根据输入构建网格
// 然后BFS探测
// 可能是BFS出错 梳理以下
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main{
    static int pos[][] = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int Th = in.nextInt();
        int M = in.nextInt();
        int N = in.nextInt();
        int K = in.nextInt();
        int grid[][] = new int[M][N];
        // 用来保存访问状态
        boolean visited[][] = new boolean[M][N];
        // 基站信息
        for(int i = 0; i < K; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int T = in.nextInt();
            setGrid(grid, x, y, T);
        }
        Deque<int[]> queue = new ArrayDeque<>();
        int [] start = {0,0};
        int res = 0;
        boolean flag = false;
        // 上下左右只用前四个
        queue.offer(start);
        visited[0][0] = true;
        while(!queue.isEmpty()&&!flag){
            int size = queue.size();
            // 按层来做
            for(int a = 0; a < size; a++){
                int[] cur = queue.poll();
                for(int i = 0; i < 4; i++){
                    int curX = cur[0] + pos[i][0];
                    int curY = cur[1] + pos[i][1];
                    // 校验是否能加入队列
                    if(curX >= 0 && curX < grid.length&& curY >=0 && curY< grid[0].length&&!visited[curX][curY]&&grid[curX][curY]>=Th){
                        if(curX == M- 1 && curY == N - 1){
                            flag = true;
                        }
                        queue.offer(new int[]{curX,curY});
                        visited[curX][curY] = true;
                    }
                    if(flag){
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
            res++;
        }
        if(flag){
            System.out.print(res);

        }else{
            System.out.print(0);
        }
    }
    // 网络、位置、强度
    public static void setGrid(int[][] grid, int x, int y, int T){
        grid[x][y] = T;
        for(int i = 0; i < 8; i++){
                int curX = x;
                int curY = y;
                int step = Math.abs(pos[i][0])+ Math.abs(pos[i][1]);
            for(int j = T; j >0; j--){
                // 在边界之内
                curX +=  pos[i][0];
                curY +=  pos[i][1];
                if(curX >= 0 && curX < grid.length&& curY >=0 && curY< grid[0].length){
                    grid[curX][curY] = Math.max(grid[curX][curY],j-step);
                }else{
                    break;
                }
            }
        }
    }
}