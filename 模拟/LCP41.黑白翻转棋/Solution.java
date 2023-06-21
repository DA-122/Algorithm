// LCP 黑白翻转棋
// 思路分析 bfs 遍历棋盘

public class Solution {
    int[][] move= {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

    public int flipChess(String[] chessboard) {
        int res = 0;
        for(int i = 0; i < chessboard.length; i++){
            for(int j = 0; j  < chessboard[0].length(); j++){
                if(chessboard[i].charAt(j) == '.'){
                    res = Math.max(res, bfs(i,j,chessboard));
                }
            }
        }
        return res;
    }
    public int bfs(int preX, int preY, String[] chessboard){
        int m = chessboard.length;
        int n = chessboard[0].length();
        char board[][] = new char[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = chessboard[i].charAt(j);
            }
        }
        int cnt = 0;
        Deque<int[]> queue= new ArrayDeque<>();
        queue.offer(new int[]{preX,preY});
        board[preX][preY] = 'X';
        while(!queue.isEmpty()){
            int pos[] = queue.poll();
            for(int i = 0; i < move.length; i++){
                if(judge(pos[0],pos[1],move[i][0],move[i][1],board)){
                    int x = pos[0] + move[i][0], y = pos[1] + move[i][1];
                    while(board[x][y] != 'X'){
                        queue.offer(new int[]{x,y});
                        board[x][y] = 'X';
                        x += move[i][0];
                        y += move[i][1];
                        cnt++;
                    }
                }

            }
        }
        return cnt;
    }
    public boolean judge(int x, int y, int dx, int dy,char[][]board){
        int curX = x + dx, curY = y + dy;
        while(curX >= 0&& curX < board.length && curY >=0 && curY < board[0].length){
            if(board[curX][curY] == 'X'){
                return true;
            }
            if(board[curX][curY] == '.'){
                return false;
            }
            curX += dx;
            curY += dy;
        }
        return false;
    }
}