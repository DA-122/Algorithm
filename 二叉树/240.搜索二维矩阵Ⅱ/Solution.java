// 240. ������ά���� II
// ��������ʱ����ת90�� ����matrix[0][n-1]Ϊ����������Կ���һ�ö���������
// ���С�ڸ��ڵ㣬�²���ڸ��ڵ�
// ʱ�临�Ӷ�O��M / N��
// �ռ临�Ӷ�O��1��

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n-1;
        while(x < m && y >= 0){
            // С�� ����
            // ���� ����
            if(matrix[x][y] < target){
                x += 1;
            }else if(matrix[x][y] > target){
                y -= 1;
            }else{
                return true;
            }
        }
        return false;
    }
}