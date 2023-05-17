// 力扣1003.检查替换后的单词是否有效
// 思路分析：栈
// 将字符串字符依次加入栈中，当栈顶为abc时依次弹出，
// 最后判断栈是否为空
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