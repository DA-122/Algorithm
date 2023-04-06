// �����������Լ��(������)��
// 1. ������: ��min(a,b)��ʼ��ǰ�������ҵ�һ����Լ��
// 2. շת�����: �� a = kb + r, ���� k = a/b, r = a%b, ��0<=r<b
// ��c��a��Լ����Ҳ��b��Լ��ʱ�����ȻҲ�� r = a - kb��Լ����
// ���a��b�Ĺ�Լ��Ҳ��b��r�Ĺ�Լ����a��b�����Լ������b��r�����Լ��
// gcd(a,b) = gcd(b,r) b != 0;
// gcd(a,b) = a = 0;
public class Solution{
    // ���ط� ʱ�临�Ӷ�O(N)
    public static int gcd1(int a, int b){
        for(int i = Math.min(a,b); i > 1; i--){
            if(a%i ==0 && b%i == 0){
                return i;
            }
        }
        return 1;
    }
    // շת�����
    public static int gcd2(int a, int b){
        return b==0? a:gcd2(b,a%b);
    }
    public static void main(String[] args){
        int a = 20, b = 15;
        System.out.println(gcd1(a, b));
        System.out.println(gcd2(a, b));
    }
}
