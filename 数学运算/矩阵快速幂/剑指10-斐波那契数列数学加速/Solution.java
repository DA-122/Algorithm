// 剑指10 -斐波那契数列
// 思路分析：动态规划复杂度为n，可以使用矩阵快速幂进一步减少复杂度
// 递推式 dp[i] = dp[i-1]+dp[i-2]
// [1 1] [ dp[n] ]     [dp[n] + dp[n-1]]    [dp[n+1]]
// [1 0] [dp[n-1]]     [    dp[n]      ]    [ dp[n] ]
// 由此可以构建出关系
// [dp[n+1]]      [1 1]^n [dp[1]]
// [ dp[n] ]   =  [1 0]   [dp[0]] 
// dp[n] = M^n-1[0][0]*dp[1]

// 正常计算M^n时间复杂度为O(N)，可以使用算法加速计算
public class Solution{
    public static final int MOD =1000000007;
    public static int fib(int n){
        if(n < 2){
            return n;
        }
        int[][] M = {{1,1},{1,0}};
        int[][] ans = pow(M,n-1) ;
        return ans[0][0];
    }
    public static int[][] pow(int[][] matrix, int n){
        // 单位矩阵
        int[][] ans = {{1, 0}, {0, 1}};
        while (n > 0) {
            // 不是2的倍数
            if ((n & 1) == 1) {
                ans = multiply(ans, matrix);
            }
            // 是2的倍数，n/2 减少运算量
            n >>= 1;
            matrix = multiply(matrix, matrix);
        }
        return ans;
    }
    public static int[][] multiply(int[][] a,int[][] b){
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }
    public static void main(String[] args){
        int n = 10;
        System.out.println(fib(n));
    }
}