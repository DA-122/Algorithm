// ��1 ջ ʱ��O(logn)���ռ�O(logn)
// ��2 sign��� ʱ��O(logn) �ռ�O(1)

public class Solution {
    public int alternateDigitSum(int n) {
        // ���sign��1��ֱ�ӷ��ؼ��ɣ����sign��-1����Ҫ�����෴��
        int res  = 0, sign = 1;
        while(n > 0){
            res += n % 10 * sign;
            sign = -sign;
            n = n / 10;
        }
        return -sign * res;
    }
}