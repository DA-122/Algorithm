// 3.19����6319.��żλ��
// ��Ŀ������һ��������n���� even ��ʾ��n�Ķ�������ʽ���±��0��ʼ����ֵΪ1��ż���±�ĸ�������odd ��ʾ��n�Ķ�������ʽ���±��0����ʼ��ֵΪ1�������±�ĸ�����
// ˼·����:��Ҫ�ӵ�λȡÿһλ����(���Ƶ�0)
// ��Ҫ�ж���λ������0����1 (��1����)
// ��Ҫ�ж���λ����������ż��(����ģ2������Ҳ���Դ�0��1���)
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
