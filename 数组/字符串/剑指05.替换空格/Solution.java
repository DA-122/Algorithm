// 剑指05.替换空格
// 思路分析：简单的模拟，注意使用Buffer会比Builder好一些。

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