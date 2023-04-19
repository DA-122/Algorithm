// 周赛341 一最多的行(Easy)
public class Solution{
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int [] ans = new int[2];
        for(int i = 0; i < mat.length; i++){
            int num = 0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    num++;
                }
            }
            if(num > ans[1]){
                ans[1] = num;
                ans[0] = i;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[][] mat ={{0,0,0},{0,1,1}};
        rowAndMaximumOnes(mat);
    }
}