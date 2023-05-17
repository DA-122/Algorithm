// 力扣1015.可被K整除的最小整数
// 题目分析:要求找出长度最小的仅包含1的且能被K整除的正整数
// 思路分析：模运算+哈希表
// 不应思考除法运算，因为这里的答案不满足64位符号数，因此可能会有超界用例，但模运算 余数不可能会超界
// n % k == 0 则可被整除,不可整除时，增加n长度
// (n*10+1) % k = ((n % k)*10 + 1) % k
// 这样就可以用到上一次求余的结果
// 当余数出现重复时，说明永远无法找到正整数

import java.util.HashSet;
import java.util.Set;

public class Solution{
    
    public static int smallestRepunitDivByK(int k) {
        // 偶数剪枝
        if(k % 2 == 0){
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        int resid = 1%k;
        int len = 1;
        while(!(set.contains(resid) || resid == 0)){
            set.add(resid);
            resid = (resid *10 +1)%k;
            len++;
        }
        return resid == 0? len:-1;

    }
    public static void main(String[] args){
        int k = 3;
        smallestRepunitDivByK(k);
    }
}