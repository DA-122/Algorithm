public class Solution{
    public static void main(String[] args){
        S solution = new S();
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        solution.searchMatrix(matrix, 3);
    }
}

class S {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right  = m - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] > target){
                right = mid - 1;
            }else if(matrix[mid][0] < target){
                left = mid + 1;
            }else{
                return true;
            }
        }
        // left 是 target所在行
        int row = right;
        left = 0;
        right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] > target){
                right  =  mid - 1;
            }else if(matrix[row][mid] < target){
                left = mid + 1;
            }else{
                return true;
            }
        
        }
        return false;
    }
}