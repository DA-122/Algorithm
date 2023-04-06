// 力扣62 不同路径
// 递推公式: d[m][n] = d[m-1][n]+d[m][n-1]
// 初始值: m = 1, d[m][n] = 1,
//         n = 1, d[m][n] = 1 
// 迭代方向:从前往后:
public class Solution
 {
    // 递归做法
    public static int uniquePathsRecu(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }else{
            return uniquePathsRecu(m-1, n) + uniquePathsRecu(m, n-1);
        }
    }
    // 迭代做法
    public static int uniquePathsIter(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }else{
            // 存放到当前位置有几种路径
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
