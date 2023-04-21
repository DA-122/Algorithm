// 力扣844.  比较含退格的字符串
// 思路分析 1.栈(空间复杂度O(M+N))
// 2.双指针（空间复杂度O(1)）
public class Solution{
    //  双指针 O(1) 空间复杂度 
    public static boolean backspaceCompare(String s, String t) {
        // 双指针 从后往前
        int sPointer = s.length()-1;
        int tPointer = t.length()-1;
        int skipS = 0;
        int skipT = 0;
        while(sPointer >=0 || tPointer>=0){
            // 这俩都不是退格，比较一下
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