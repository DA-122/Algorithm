// ��ָ16.��ֵ������
// ʵ��pow���㣬�����ÿ������㷨
// ����ת��Ϊ����������
public class Solution{
    // ����
    public static double myPow(double x, int n) {
        // ��long��ֹ�������
        // -2^31תΪ���������Ϊ0
        long N = n;
        return N>=0? pow(x,N):1/pow(x,-N);

    }
    public static double pow(double x, long n){
        double ans = 1.0;
        while(n>0){
            //��1�ı���
            if(n%2 != 0){
                ans = ans*x;
            }
            n = n/2;
            x = x*x;
        }
        return ans;
    }
    // �ݹ�
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
