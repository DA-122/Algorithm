//剑指 Offer 46. 把数字翻译成字符串
//思路分析: dp[i] 是到第i位数字，当前有多少种翻译方法；
// 注意：这里的i是从后往前数
// dp[i] = dp[i-1]+dp[i-2]; 如果i位和i-1位可以组合翻译(10 < = i*10+i-1 <= 25)
// dp[i] = dp[i-1]; 不可以组合翻译
// 初始化: dp[0] =1; dp[1] = 1 从第二位开始遍历
// 迭代方向:便于编程，从后往前
// eg: num: 12441431    方向  <——

public class Solution{
    public static int translateNum(int num) {
        int ans = 1;
        int a = 1;
        int b = 1;
        int lastNum = num%10;
        num = num/10;
        while(num!=0){
            int curNum = num%10;
            num = num/10;
            //注意 06这种也只有一种翻译法
            if(curNum*10+lastNum>25 || curNum*10 + lastNum < 10){
                ans =  a;
                b = a;
                a = ans;
            }else{
                ans = a+b;
                b = a;
                a = ans;
            }
            lastNum = curNum;
        }
        return ans;
    }
    public static void main(String[] args){
        int num = 26;
        System.out.println(translateNum(num));
    }
}