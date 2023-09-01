// 力扣48. 旋转图像
// 思路分析：模拟
// 注意旋转90度的坐标变换
// newX = y, newY = n - x - 1
// x需要中间变量保留

public class Solution {
    // 顺时针转
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

    // 逆时针转 newX = n - y - 1, newY = x
    // 其实不写循环更容易写，毕竟只有4个数
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        int left = 0, right = n - 1,top = 0, down = n - 1;
        while(top < down){
            for(int i = left; i < right; i++){
                // 逆时针更新四个参数
                int x = top, y = i;
                int temp = matrix[x][y];
                int newX = n - y - 1, newY = x;
                for(int j = 0; j < 3; j++){
                    matrix[x][y] = matrix[newX][newY];
                    x = newX;
                    y = newY;
                    newX = n - y - 1;
                    newY = x;
                } 
                matrix[x][y] = temp;
            }
            left++;
            right--;
            top++;
            down--;
        }
    }



    public static void main(String[] args) {
        int matrix [][] = {{1,2,3},{4,5,6},{7,8,9}};
        rotate2(matrix); 
    }
}