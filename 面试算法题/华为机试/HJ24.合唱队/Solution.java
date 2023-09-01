import java.util.Scanner;

// 思路分析： 动态规划
// 需要构建两个DP数组
// 最大递增子序列
// 最大递减子序列
// 时间复杂度O(n^2)
// 空间复杂度O(n)

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int heights[] = new int[N + 2];
        for(int i = 1; i <= N ; i++ ){ // [1,n]范围内是身高数据
            heights[i] = in.nextInt();
        }
        int dp1[] = new int[N+2]; // 存储每个位置左侧的最长递增子序列长度
        int dp2[] = new int[N+2]; // 存储每个位置右侧的最长递增子序列长度
        for(int i = 1; i <= N; i++){
            for(int j = i - 1; j >=0; j--){
                if(heights[i] > heights[j]){
                    dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                }
            }
        }
        for(int i = N; i > 0; i--){
            for(int j = i + 1; j <= N+1; j++){
                if(heights[i] > heights[j]){
                    dp2[i] = Math.max(dp2[j] + 1,dp2[i]) ;
                }
            }
        }
        int res = 1;
        for(int i = 1; i <= N; i++){
            res = Math.max(dp1[i]+dp2[i]-1, res);
        }
        System.out.print(N - res);
    }
}