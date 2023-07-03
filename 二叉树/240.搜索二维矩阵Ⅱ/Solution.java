// 240. 搜索二维矩阵 II
// 将矩阵逆时针旋转90度 ，以matrix[0][n-1]为根，矩阵可以看做一棵二叉搜索树
// 左侧小于父节点，下侧大于父节点
// 时间复杂度O（M / N）
// 空间复杂度O（1）

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n-1;
        while(x < m && y >= 0){
            // 小于 向下
            // 大于 向左
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