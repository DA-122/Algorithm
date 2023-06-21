// ����48. ��תͼ��
// ˼·������ģ��
// ע����ת90�ȵ�����任
// newX = y, newY = n - x - 1
// x��Ҫ�м��������

public class Solution {
    public  static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int x = 0; x < n / 2 ; x++){
            for(int y = x; y < n - x -1; y++){
                int curX = x, curY = y;
                int pre = matrix[x][y];
                int temp = pre;
                for(int i = 0; i < 4; i++){
                    // ����
                    temp = matrix[curY][n - curX -1];
                    matrix[curY][n - curX -1] = pre;
                    pre = temp;
                    // ���� curX, curY
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