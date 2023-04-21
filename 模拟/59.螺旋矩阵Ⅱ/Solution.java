// 力扣59. 螺转矩阵
// 思路分析：offset

public class Solution {
    public static int[][] generateMatrix(int n) {
        int [][] result = new int [n][n];
        int startx = 0, starty = 0;
        int offset = 0;
        int i = 1;
        while(i <= n*n){
            for(; startx < n - offset - 1; startx++,i++ ){
                result[starty][startx] = i ;
            }
            for(; starty < n - offset - 1; starty++,i++ ){
                result[starty][startx] = i ;
            }
            for(; startx > 0 + offset; startx--, i++ ){
                result[starty][startx] = i;
            }
            for(; starty > 0 + offset; starty--, i++ ){
                result[starty][startx] = i;
            }
            starty++;
            startx++;
            offset++;
        }
        if (n % 2 == 1) {
            int mid = n/2;
            result[mid][mid] = i;
        }
        return result;
    }
    // 学习k神代码, l r t b 分别表示四个边界，每填充一行或一列就压缩边界
    public int[][] generateMatrix2(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
    
    public static void main(String [] args){
        int n = 3;
        generateMatrix(n);
    }
}
