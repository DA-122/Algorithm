// ����1147. ��ʽ����
// ˼·������1. ̰���㷨+��ָ��(�Խ�)
// ������ϣ(�ٽ�)
public class Solution{
    public static int longestDecomposition(String text) {
        int n = text.length();
        int leftStart = 0;
        int leftEnd = 0;
        int right = n-1;
        int ans = 0;
        // �ֳ�������ǰ��׺
        while(leftEnd < n/2){
            // leftEnd������right���򲻿�����ȣ����������
            if(text.charAt(leftEnd)!=text.charAt(right)){
                leftEnd++;
            // �ҵ��󰤸��Ա�
            }else{
                int i = leftEnd;
                int j = right;
                while(i >= leftStart){
                    if(text.charAt(i) == text.charAt(j)){
                        j--;
                        i--;
                    }else{
                        break;
                    }
                }
                // ���ǰ��׺��ȣ�����ָ�����
                if(i == leftStart-1){
                    right = j;
                    leftStart = leftEnd+1;
                    leftEnd = leftEnd+1;
                    ans = ans+2;
                // ����leftEnd����ǰ��
                }else{
                    leftEnd++;
                }
            }
        }
        // leftEnd��leftStart�1����˵�������Ĵ���һ���޷��ָ���ַ���
        // leftEnd = leftStart = right ˵�����������ֻ�����м�һ���ַ��ϣ����������ַ���
        if(leftEnd -leftStart >0 || leftEnd==leftStart&&leftEnd == right){
            ans+= 1;
        }
        return ans;
    }
    public static int longestDecomposition2(String text){

    }


    public static void main(String[] args){
        String text ="aaa";
        System.out.println(longestDecomposition(text));
    }
}