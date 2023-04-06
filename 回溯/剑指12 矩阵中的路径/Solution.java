public class Solution{
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(check(board,visited,i,j,word,0))
                    return true;
            }
        }
        return false;
    }
    public static boolean check(char[][]board,boolean[][] visited, int i, int j, String s, int k){
        if(board[i][j] != s.charAt(k)){
            return false;
        }else if(k == s.length()-1){
            return true;
        }
        visited[i][j] = true;
        boolean result = false;
        // 分别代表右 左 下 上
        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir: directions){
            int newI = i + dir[0],  newJ = j + dir[1];
            if(newI>=0&&newI<board.length&&newJ>=0&&newJ<board[0].length){
                if(!visited[newI][newJ]){
                    if((check(board, visited, newI, newJ, s, k+1))){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
    public static void main(String[] args){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        System.out.println(exist(board, word));
    }
}