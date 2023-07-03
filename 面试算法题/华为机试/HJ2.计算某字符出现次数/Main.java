// 注意不区分大小写
// 需要大小写转化
// 'a' = 'A' + 32
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line =  in.nextLine();
        char word = in.nextLine().charAt(0);
        int cnt = 0;
        for (char c : line.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (c == word || word == Character.toUpperCase(c)) {
                    cnt++;
                }
            } else {
                if ( c == word || word == Character.toLowerCase(c)) {
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}