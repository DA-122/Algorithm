// ����1003.����滻��ĵ����Ƿ���Ч
// ˼·������ջ
// ���ַ����ַ����μ���ջ�У���ջ��Ϊabcʱ���ε�����
// ����ж�ջ�Ƿ�Ϊ��
public class Solution{
    public static boolean isVaild(String s){
        char[] words = new char[s.length()];
        int top = 0;
        for(char word : s.toCharArray()){
            words[top++] = word;
            if(word == 'c'&& top >= 3&& words[top-3] =='a'&&words[top-2]=='b'){
                top-=3;
            }
        }
        return top==0;
    }
    public static void main(String[] args){
        String s = "abcabcababcc";
        isVaild(s);
    }
}