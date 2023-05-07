// ����1010 �ܳ���ʱ��ɱ�60�����ĸ���
// ˼·������ a + b = 60����
// a % 60 + b % 60 = 60;,
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int cnt [] = new int[60];
        long result = 0L;
        for(int i = 0; i < time.length; i++){
            cnt[time[i]%60]++;
        }
        // ��������ֵ 0 �� 30
        // 0 + 60    30 * 30
        for(int i = 1; i < 30; i++){
            result+= cnt[i]*cnt[60-i];
        }
        result += (long)cnt[0] * (cnt[0] - 1) / 2 + (long) cnt[30] * (cnt[30] - 1) / 2;
        return (int) result;
    }
}