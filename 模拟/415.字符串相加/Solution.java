//  力扣415. 字符串相加

// 思路分析： 模拟即可
public class Solution{
    public static void main(String[] args){
        S s = new S();
        String s1 = "1";
        String s2 = "9";
        s.addStrings(s1, s2);
    }
}


class S {
    public String addStrings(String num1, String num2) {
        int res = 0;
        int cur = 0;
        int m = num1.length();
        int n = num2.length();
        int min = Math.min(m,n);
        StringBuilder builder = new StringBuilder();
        while(cur < min){
            int sum = num1.charAt(m - 1 - cur) - '0' + num2.charAt(n - 1 - cur) - '0' + res;
            res = sum / 10;
            builder.insert(0,sum % 10);
            cur++;
        }
        while(m - 1 -cur >= 0){
            int sum = num1.charAt(m - 1 - cur) - '0' + res;
            res = sum / 10;
            builder.insert(0,sum % 10);
            cur++;
        }
        while(n - 1 -cur >= 0){
            int sum = num2.charAt(n - 1 - cur) - '0' + res;
            res = sum / 10;
            builder.insert(0,sum % 10);
            cur++;
        }
        if(res != 0){
            builder.insert(0,'0' + res);
        }
        return builder.toString();
    }

    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

}