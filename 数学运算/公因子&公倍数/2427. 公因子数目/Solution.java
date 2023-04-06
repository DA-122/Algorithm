// 力扣2427 求两个数公因子数目
public class Solution{
    // 方法1 遍历到a，b中较小的一个数，判断是否是公因子
    // 时间复杂度O(b)， 空间复杂度O(1)
    public static int commonFactors1(int a, int b){
        int ans = 0;
        for(int i = 1;  i <= Math.min(a,b); i++){
            if(a%i == 0 && b%i == 0)
                ans++;
        }
        return ans;
    }
    // 方法2 找到a和b的最大公因子c，最大公因子的因子，一定是a和b的公因子
    // 时间复杂度O(sqrt(c))
    public static int commonFactors2(int a, int b) {
        int c = gcd(a, b), ans = 0;
        for (int x = 1; x * x <= c; ++x) {
            if (c % x == 0) {
                ++ans;
                if (x * x != c) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return a;
    }
    public static void main(String[] args){
        int a = 20;
        int b = 15;
        System.out.println(commonFactors1(a, b));
        System.out.println(commonFactors2(a, b));
    }
}