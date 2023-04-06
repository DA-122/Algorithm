// 两个数的最大公约数(公因子)求法
// 1. 朴素求法: 从min(a,b)开始向前遍历，找第一个公约数
// 2. 辗转相除法: 令 a = kb + r, 则有 k = a/b, r = a%b, 且0<=r<b
// 当c是a的约数，也是b的约数时，则必然也是 r = a - kb的约数，
// 因此a和b的公约数也是b和r的公约数，a和b的最大公约数就是b和r的最大公约数
// gcd(a,b) = gcd(b,r) b != 0;
// gcd(a,b) = a = 0;
public class Solution{
    // 朴素法 时间复杂度O(N)
    public static int gcd1(int a, int b){
        for(int i = Math.min(a,b); i > 1; i--){
            if(a%i ==0 && b%i == 0){
                return i;
            }
        }
        return 1;
    }
    // 辗转相除法
    public static int gcd2(int a, int b){
        return b==0? a:gcd2(b,a%b);
    }
    public static void main(String[] args){
        int a = 20, b = 15;
        System.out.println(gcd1(a, b));
        System.out.println(gcd2(a, b));
    }
}
