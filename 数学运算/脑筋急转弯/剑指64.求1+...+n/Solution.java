// 剑指64 求1+2+…+n
// 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
// 思路分析：递归 代替 循环

public class Solution {
    public int sumNums(int n) {
        return n == 0? 0: sumNums(n-1)+n; 
    }
}
