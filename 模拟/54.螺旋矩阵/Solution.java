// ����54. ��������1
// ˼·������ ע�����д��������������2���ϼ���

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, down = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int num = 0 ;
        int n  = matrix.length*matrix[0].length;

        while(num < n){
            for(int i = left; num < n && i <= right; i++){
                res.add(matrix[top][i]);
                num++;
            }
            top++;
            for(int i = top; num < n && i <= down; i++){
                res.add(matrix[i][right]);
                num++;
            }
            right--;
            for(int i = right; num < n && i >= left; i--){
                res.add(matrix[down][i]);
                num++;
            }
            down--;
            for(int i = down; num < n && i >= top; i--){
                res.add(matrix[i][left]);      
                num++;
            }
            left++;
        }
        return res;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(matrix);
    }

}
