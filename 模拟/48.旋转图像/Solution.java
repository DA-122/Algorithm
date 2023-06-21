// 力扣48. 旋转图像
// 思路分析：模拟
// 注意旋转90度的坐标变换
// newX = y, newY = n - x - 1
// x需要中间变量保留

public class Solution {
    public  static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int x = 0; x < n / 2 ; x++){
            for(int y = x; y < n - x -1; y++){
                int curX = x, curY = y;
                int pre = matrix[x][y];
                int temp = pre;
                for(int i = 0; i < 4; i++){
                    // 保留
                    temp = matrix[curY][n - curX -1];
                    matrix[curY][n - curX -1] = pre;
                    pre = temp;
                    // 更新 curX, curY
                    int t = curX;
                    curX = curY;
                    curY = n - t -1;
                }
            }
        }
    }
    public static void main(String[] args) {
        int matrix [][] = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix); 
    }
}