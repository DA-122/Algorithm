// ����1186 ɾ��һ�εõ�����������
// ˼·������1 ��̬�滮
// dp[i][k] ��k��λ�ķǿ������飬ɾ��k�ε�����
// dp[i][0] = max(0,dp[i-1][0]) + arr[i])
// dp[i][1] = max(dp[i-1][0],dp[i-1][1]+arr[i])
// 2��ǰ��׺�ֽ�



class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][2];
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        int res = dp[0][0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(0,dp[i-1][0]) + arr[i];
            dp[i][1] = Math.max(dp[i-1][1]+arr[i],dp[i-1][0]);
            res = Math.max(Math.max(dp[i][0],dp[i][1]),res);
        }
        return res;
    }
}
