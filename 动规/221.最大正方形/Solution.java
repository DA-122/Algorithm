import javax.swing.plaf.basic.BasicBorders.MarginBorder;

public class Solution{
    public static void main(String[] args){
        char[][] matrix = {
        {'1','0','1','0','0'},
        {'1','0','1','1','1'},
        {'1','1','1','1','1'},
        {'1','0','0','1','0'}
        // {'0','0','1','1','1'}
    };
        System.out.print(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
            }
        }
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j <n ; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    max= Math.max(dp[i][j],max);
                }
            }
        }
        return max*max;

    }
}

