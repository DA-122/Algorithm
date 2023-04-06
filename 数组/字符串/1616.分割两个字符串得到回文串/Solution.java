// 力扣1616. 分割两个字符串得到回文串
// 思路分析：双指针法
class Solution {
    public static boolean checkPalindromeFormation(String a, String b) {
        int length = a.length();
        int aPrefix = 0;
        int bPrefix = 0;
        while (aPrefix < length){
            if(a.charAt(aPrefix) == b.charAt(length-1-aPrefix))
                aPrefix++;
            else
                break;
        }
        if(aPrefix*2 == length-1 || aPrefix*2 == length){
            return true;
        }
        if(checkPalindrome(aPrefix,length-aPrefix-1,a)||checkPalindrome(aPrefix,length-aPrefix-1,b)){
            return true;
        }

        while (bPrefix < length){
            if(b.charAt(bPrefix) == a.charAt(length-1-bPrefix))
                bPrefix++;
            else
                break;
        }
        if(bPrefix*2 == length-1 || bPrefix*2 == length){
            return true;
        }
        if(checkPalindrome(bPrefix,length-bPrefix-1,a)||checkPalindrome(bPrefix,length-bPrefix-1,b)){
            return true;
        }
        return false;
    }
    public static boolean checkPalindrome(int left, int right, String str){
        while(left <= right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else    
                break;
        }
        if(left > right)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        String a = "pvhmupgqeltozftlmfjjde";
        String b = "yjgpzbezspnnpszebzmhvp";
        System.out.println(checkPalindromeFormation(a,b));      
    }
}