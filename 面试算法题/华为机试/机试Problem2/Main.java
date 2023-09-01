// ��ɫ �յ�
// ��ɫ ��վ
// ��ɫ �źŸ���

// BFS����
// ���裺�ȸ������빹������
// Ȼ��BFS̽��
// ������BFS���� ��������
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
        // �����������״̬
        boolean visited[][] = new boolean[M][N];
        // ��վ��Ϣ
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
        // ��������ֻ��ǰ�ĸ�
        queue.offer(start);
        visited[0][0] = true;
        while(!queue.isEmpty()&&!flag){
            int size = queue.size();
            // ��������
            for(int a = 0; a < size; a++){
                int[] cur = queue.poll();
                for(int i = 0; i < 4; i++){
                    int curX = cur[0] + pos[i][0];
                    int curY = cur[1] + pos[i][1];
                    // У���Ƿ��ܼ������
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
    // ���硢λ�á�ǿ��
    public static void setGrid(int[][] grid, int x, int y, int T){
        grid[x][y] = T;
        for(int i = 0; i < 8; i++){
                int curX = x;
                int curY = y;
                int step = Math.abs(pos[i][0])+ Math.abs(pos[i][1]);
            for(int j = T; j >0; j--){
                // �ڱ߽�֮��
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