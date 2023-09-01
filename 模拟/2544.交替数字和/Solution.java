// 法1 栈 时间O(logn)，空间O(logn)
// 法2 sign标记 时间O(logn) 空间O(1)

public class Solution {
    public int alternateDigitSum(int n) {
        // 最后sign是1，直接返回即可，最后sign是-1，需要返回相反数
        int res  = 0, sign = 1;
        while(n > 0){
            res += n % 10 * sign;
            sign = -sign;
            n = n / 10;
        }
        return -sign * res;
    }
}