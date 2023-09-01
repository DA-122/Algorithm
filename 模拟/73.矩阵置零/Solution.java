// 时间复杂度O(mn)
// 法1 visited 数组记录需要变化的位置 空间复杂度 O(m+n)
// 法2 使用两个数组来保存，一个数组保存行，一个数组保存列，两次遍历，第一次遍历更新数组，第二次遍历如果row col都有，说明需要设为0
// 法3 原地算法

public class Solution {
    // 法2
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
    // 法3
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