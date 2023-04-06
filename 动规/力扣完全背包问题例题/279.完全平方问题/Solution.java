// 力扣279 完全平方数
// 思路分析：类似于322零钱兑换，只是coins数组现在可变
// 根据遍历时i的值变化  j ∈ [0,sqrt(i)]

// 数学定理法：四平方和定理
public class Solution {
    public static int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i < dp.length;i++){
            dp[i] = n+1;
        }
        for(int i = 0; i <=n; i++){
            for(int j = 1; j <=Math.sqrt(n);j++){
                if(j*j <= i){
                    dp[i] = Math.min(dp[i],dp[i-j*j]+1);
                }
            }
        }
        return dp[n];
    }
    public static int mathMethods(int n) {
        if(checkAnswer1(n))
            return 1;
        if(checkAnswer2(n))
            return 2;
        if(checkAnswer4(n))
            return 4;
        return 3;
    }
    public static boolean checkAnswer4(int n){
        while(n%4==0){
            n=n/4;
        }
        return n%8==7;
    }
    public static boolean checkAnswer1(int n){
        return (int)Math.sqrt(n)*(int)Math.sqrt(n) == n;
    }
    public static boolean checkAnswer2(int n){
        for(int i = 1; i <= Math.sqrt(n);i++){
            int j = n - i*i;
            if((int)Math.sqrt(j)*(int)Math.sqrt(j) == j)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        int n = 12;
        System.out.println(numSquares(n));
        System.out.println(mathMethods(n));

    }
}
