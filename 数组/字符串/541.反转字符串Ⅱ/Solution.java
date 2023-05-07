// 力扣541 反转字符串Ⅱ
// 思路分析：分段双指针
public class Solution{
    public static void reverseString(char[] s,int left, int right) {
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    public static String reverseStr(String s, int k) {
        char c[] = s.toCharArray();
        int n = c.length;
        int a = n/(2*k);
        int b = n%(2*k);
        for(int i = 0; i < a; i++){
            int left = i*2*k;
            int right = (i*2+1)*k-1;
            reverseString(c,left,right);
        }
        if(b < k){
            reverseString(c,a*2*k,n-1);
        }else{
            reverseString(c,a*2*k, (a*2+1)*k-1);
        }
        return String.copyValueOf(c);
    }
    public static void main(String[] args){
        String s = "abcdefg";
        int k = 2;
        reverseStr(s, k);
    }
}