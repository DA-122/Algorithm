// ����62 ��ͬ·��
// ���ƹ�ʽ: d[m][n] = d[m-1][n]+d[m][n-1]
// ��ʼֵ: m = 1, d[m][n] = 1,
//         n = 1, d[m][n] = 1 
// ��������:��ǰ����:
public class Solution
 {
    // �ݹ�����
    public static int uniquePathsRecu(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }else{
            return uniquePathsRecu(m-1, n) + uniquePathsRecu(m, n-1);
        }
    }
    // ��������
    public static int uniquePathsIter(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }else{
            // ��ŵ���ǰλ���м���·��
            int [][] grid = new int[m][n];
            for(int i = 0; i < m; i++){
                grid[i][0] = 1;
            }
            for(int i = 0; i < n; i++){
                grid[0][i] = 1;
            }

            for(int i = 1; i< m; i++){
                for(int j = 1; j<n;j++){
                    grid[i][j] = grid[i-1][j]+grid[i][j-1];
                }
            }
            return grid[m-1][n-1];
        }
    }
    public static void main(String[] args){
        System.out.println("Recursion:"+uniquePathsRecu(3,7));
        System.out.println("Iteration:"+uniquePathsIter(3,7));
    }
}
