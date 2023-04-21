// 1043. �ָ�����õ�����
// ˼·����������dp����,ö�ٵ�i����i��Ϊĩβ����[i-k,i-1]��Χ��ö��j,��[j+1,i]�����µ�һ��,�����ظ�dp[n]��������
// dp���飺dp[n+1] dp[i]��ʾ��i��β�ָ�������
// ���ƹ�ʽ: dp[i] = max(dp[j],maxValue*(i-j))  maxValue�Ǵ�j-i��������
// ��ʼ��: dp[0] =0;
// ����˳�򣺴�ǰ����

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
