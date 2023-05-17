// ����459 �ظ������ַ���
// 1.ö�ٷ�O(N^2)
// �ַ��� == �Ƚ����õ�ַ��equals�Ƚ��ַ�������
// �������� == ��ʾ���õ�ַ�� equalsĬ�ϵ���==���������ͱȽ��������equals��������equals�Ƚ�ֵ
// 2.�ַ���ƥ��
// �ַ���s����д��s's'......s's' �ܹ� n/n'��s'
// ����Ƴ�һ��s'�ٰ�s'��ӵ��ַ���ĩβ���õ����ַ�����Ȼ��s
// 
public class Solution{
    public static boolean repeatedSubstringPattern(String s) {
        StringBuffer str =  new StringBuffer();
        int n = s.length();
        for(int i = 0; i < n/2; i++){
            int len = i + 1;
            str.append(s.charAt(i));
            if(n % len!=0){
                continue;
            }else{
                int j = 0;
                while(j < n/len){
                    if(!s.substring(len*j,len*(j+1)).equals(str.toString())){
                        break;
                    }
                    j++;
                }
                if(j == n/len){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        String s = "aba";
        repeatedSubstringPattern(s);
    }
}