// ��ָ15.��������1�ĸ���
// ˼·������1.�������жϵ�λ�Ƿ�Ϊ1���������㲻��ȡ��λ���ܹ�32��
// 2.��2^i��n�������㣬����λ���ж����е�λ���Ƿ�Ϊ1
// 3.n&(n-1) ���n���λ��1��תΪ0��
// ���� 6(110) 5(101)  6&5=4(100)
// 4(100) 3(011) 4&3 = 000(0)
// ������n���ϵ���n-1ȥ�������㣬��ת��λ1��ֱ��Ϊ0����ת��������1��λ��
public class Solution{
    public static int hammingWeight(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            ans += n&1;
            n = n>>1;
        }
        return ans;
    }
    public static int hammingWeight2(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            // 1����iλ��ȡ��2^i-1 Ȼ����n��������
            ans += n&((1 << i));
        }
        return ans;
    }
    // ʱ�临�Ӷ�O(logN)
    public static int hammingWeight3(int n) {
        int ans = 0;
        while(n!=0){
            n = n&(n-1);
            ans++;
        }
        return ans;
    }
    public static void main(String[] args){
        int n = 11;
        System.out.println(hammingWeight3(n));
    }
}
