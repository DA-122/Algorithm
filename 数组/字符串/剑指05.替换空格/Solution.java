// ��ָ05.�滻�ո�
// ˼·�������򵥵�ģ�⣬ע��ʹ��Buffer���Builder��һЩ��

public class Solution{
    public static String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == ' ' ){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String s = "We are happy.";
        replaceSpace(s);
    }
}