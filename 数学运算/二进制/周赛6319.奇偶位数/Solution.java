// 3.19周赛6319.奇偶位数
// 题目：给你一个正整数n。用 even 表示在n的二进制形式（下标从0开始）中值为1的偶数下标的个数。用odd 表示在n的二进制形式（下标从0）开始中值为1的奇数下标的个数。
// 思路分析:需要从低位取每一位数字(右移到0)
// 需要判断这位数字是0还是1 (与1操作)
// 需要判断这位是奇数还是偶数(可以模2操作，也可以从0与1异或)
public class Solution {
    public static int[] evenOddBit(int n) {
        int[] ans = new int[2];
        for(int i = 0; n>0; i^=1,n>>=1){
            ans[i] += n&1;
        }
        return ans;
    }
    public static void main(String[] args){
        int n = 17;
        System.out.println(evenOddBit(n));
    }
}
