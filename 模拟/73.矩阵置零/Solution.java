// ʱ�临�Ӷ�O(mn)
// ��1 visited �����¼��Ҫ�仯��λ�� �ռ临�Ӷ� O(m+n)
// ��2 ʹ���������������棬һ�����鱣���У�һ�����鱣���У����α�������һ�α����������飬�ڶ��α������row col���У�˵����Ҫ��Ϊ0
// ��3 ԭ���㷨

public class Solution {
    // ��2
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j <n ; j++){
                if(matrix[i][j] == 0){  
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j <n ; j++){
                if(rows[i] || cols[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    // ��3
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for(int i = 0;  i < m; i++){
            if(matrix[i][0] == 0){
                flagCol0 = true;
            }
        }
        for(int i = 0;  i < n; i++){
            if(matrix[0][i] == 0){
                flagRow0 = true;
            }
        }    
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}