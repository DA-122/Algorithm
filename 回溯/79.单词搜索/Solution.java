// 79.��������
// ˼·���������ݷ�����Ҫ�����¼���ʣ�
// ʱ�临�Ӷ�O��MN 3^L�� �ռ临�Ӷ� O��MN������ջ��Ⱥ�visited����
class S {
    int [][] pos = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean result =false;
        boolean visited[][] = new boolean[m][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0))
                    if(check(board,visited,i,j,0,word)){
                        result =true;
                        break;
                    }
            }
        }
        return result;
    }
    // ����check
    public boolean check(char[][]board,boolean[][]visited,int x, int y, int cur, String word){
        if(cur == word.length()-1){
            return true;
        }
        boolean result  = false;
        visited[x][y] = true;
        for(int i = 0; i < pos.length; i++){
            int curX = pos[i][0] + x;
            int curY = pos[i][1] + y;
            // ����߽�  �ɷ��� ��ĸ���
            if(curX >=0 && curX < board.length && curY >=0 && curY <board[0].length&&!visited[curX][curY]&&board[curX][curY]==word.charAt(cur+1)){
                if(check(board,visited,curX,curY,cur+1,word)){
                    result = true;
                    break;
                }
            }
        }
        visited[x][y] = false;
        return result;
    }
}
public class Solution{
    public static void main(String args[]){
        S solution = new S();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String s= "SEE";
        solution.exist(board, s);
    }
}