// ����2427 ����������������Ŀ
public class Solution{
    // ����1 ������a��b�н�С��һ�������ж��Ƿ��ǹ�����
    // ʱ�临�Ӷ�O(b)�� �ռ临�Ӷ�O(1)
    public static int commonFactors1(int a, int b){
        int ans = 0;
        for(int i = 1;  i <= Math.min(a,b); i++){
            if(a%i == 0 && b%i == 0)
                ans++;
        }
        return ans;
    }
    // ����2 �ҵ�a��b���������c��������ӵ����ӣ�һ����a��b�Ĺ�����
    // ʱ�临�Ӷ�O(sqrt(c))
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