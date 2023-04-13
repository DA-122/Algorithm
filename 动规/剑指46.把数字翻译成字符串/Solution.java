//��ָ Offer 46. �����ַ�����ַ���
//˼·����: dp[i] �ǵ���iλ���֣���ǰ�ж����ַ��뷽����
// ע�⣺�����i�ǴӺ���ǰ��
// dp[i] = dp[i-1]+dp[i-2]; ���iλ��i-1λ������Ϸ���(10 < = i*10+i-1 <= 25)
// dp[i] = dp[i-1]; ��������Ϸ���
// ��ʼ��: dp[0] =1; dp[1] = 1 �ӵڶ�λ��ʼ����
// ��������:���ڱ�̣��Ӻ���ǰ
// eg: num: 12441431    ����  <����

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
            //ע�� 06����Ҳֻ��һ�ַ��뷨
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