// ����844.  �ȽϺ��˸���ַ���
// ˼·���� 1.ջ(�ռ临�Ӷ�O(M+N))
// 2.˫ָ�루�ռ临�Ӷ�O(1)��
public class Solution{
    //  ˫ָ�� O(1) �ռ临�Ӷ� 
    public static boolean backspaceCompare(String s, String t) {
        // ˫ָ�� �Ӻ���ǰ
        int sPointer = s.length()-1;
        int tPointer = t.length()-1;
        int skipS = 0;
        int skipT = 0;
        while(sPointer >=0 || tPointer>=0){
            // �����������˸񣬱Ƚ�һ��
            while(sPointer>=0){
                if(s.charAt(sPointer) == '#'){
                    skipS++; 
                    sPointer--;
                }else if(skipS!=0){
                    skipS--;
                    sPointer--;
                }else{
                    break;
                }
            }
            while(tPointer>=0){
                if(t.charAt(tPointer) == '#'){
                    skipT++; 
                    tPointer--;
                }else if(skipT!=0){
                    skipT--;
                    tPointer--;
                }else{
                    break;
                }
            }
            if(sPointer >=0 && tPointer>=0){
                if(s.charAt(sPointer) == t.charAt(tPointer)){
                    sPointer--;
                    tPointer--;
                }else{
                    return false;
                }
            }else{
                if(sPointer >=0 || tPointer >=0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        String s = "ab##";
        String t = "a#b#";
        System.out.println(backspaceCompare(s, t));
    }
}