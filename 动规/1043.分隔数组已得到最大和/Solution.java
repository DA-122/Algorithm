// 1043. 分隔数组得到最大和
// 思路分析：区间dp问题,枚举到i，将i作为末尾，在[i-k,i-1]范围内枚举j,将[j+1,i]当作新的一段,不断重复dp[n]就是所求
// dp数组：dp[n+1] dp[i]表示以i结尾分隔的最大和
// 递推公式: dp[i] = max(dp[j],maxValue*(i-j))  maxValue是从j-i中最大的数
// 初始化: dp[0] =0;
// 遍历顺序：从前往后

public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxValue = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                d[i] = Math.max(d[i], d[j] + maxValue * (i - j));
                if (j > 0) {
                    maxValue = Math.max(maxValue, arr[j - 1]);
                }
            }
        }
        return d[n];
    }
}
