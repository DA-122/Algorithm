// ����48. ��תͼ��
// ˼·������ģ��
// ע����ת90�ȵ�����任
// newX = y, newY = n - x - 1
// x��Ҫ�м��������

public class Solution {
    // ˳ʱ��ת
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

    // ��ʱ��ת newX = n - y - 1, newY = x
    // ��ʵ��дѭ��������д���Ͼ�ֻ��4����
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        int left = 0, right = n - 1,top = 0, down = n - 1;
        while(top < down){
            for(int i = left; i < right; i++){
                // ��ʱ������ĸ�����
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