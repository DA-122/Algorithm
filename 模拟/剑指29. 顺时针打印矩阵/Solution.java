public class Solution {
    public static int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return new int[0];
        }
        int m = matrix[0].length;
        int [] ans = new int[n*m]; 
        int l =0, r = m-1, t =0, b = n-1;
        int num = 0;
        while(num < n*m){
            for(int i = l; i <= r && num<n*m ; i++){
                ans[num++] = matrix[t][i];
            }
            t++;
            for(int i = t; i <= b && num<n*m;  i++){
                ans[num++] = matrix[i][r];
            }
            r--;
            for(int i = r; i >= l && num<n*m; i--){
                ans[num++] = matrix[b][i];
            }
            b--;
            for(int i = b; i >= t && num<n*m; i--){
                ans[num++] = matrix[i][l];
            }
            l++;
        }
        return ans;  
    }
    
    public static void main(String[] args){
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(matrix);
    }
}
