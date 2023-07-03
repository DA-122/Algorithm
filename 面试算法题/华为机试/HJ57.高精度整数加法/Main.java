import java.util.Scanner;

// 分段31位31位的读数

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1 = in.nextLine();
        String num2 = in.nextLine();
        int len1 = num1.length() -1;
        int len2 = num2.length() -1;
        int last = 0;
        StringBuilder sb = new StringBuilder();
        while(len1 >= 0 || len2 >= 0){
            char c1 = len1 >= 0? num1.charAt(len1--):'0';
            char c2 = len2 >= 0? num2.charAt(len2--):'0';
            int sum = (c1 -'0') + (c2-'0') + last;
            sb.append(Integer.toString(sum%10));
            last = sum / 10;
        }
        if(last == 1){
            sb.append(last);
        }
        System.out.print(sb.reverse().toString());
    }
}