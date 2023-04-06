// 剑指16.数值整数幂
// 实现pow运算，可以用快速幂算法
// 负数转化为正数快速幂
public class Solution{
    // 迭代
    public static double myPow(double x, int n) {
        // 用long防止溢出错误
        // -2^31转为正数就溢出为0
        long N = n;
        return N>=0? pow(x,N):1/pow(x,-N);

    }
    public static double pow(double x, long n){
        double ans = 1.0;
        while(n>0){
            //是1的倍数
            if(n%2 != 0){
                ans = ans*x;
            }
            n = n/2;
            x = x*x;
        }
        return ans;
    }
    // 递归
    public static double myPow2(double x, int n){
        long N = n;
        return N>=0? pow(x,N):1/pow(x,-N);
    }
    public static double pow2(double x, long n){
        if(n == 0)
            return 1;
        if((n&1) == 1){
            return x*pow(x,n-1);
        }
        n>>=1;
        return pow(x*x,n);
    }
    public static void main(String[] args){
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(myPow(x, n));
        System.out.println(myPow2(x, n));
    }
}
