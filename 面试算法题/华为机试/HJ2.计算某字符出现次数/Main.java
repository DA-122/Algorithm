// ע�ⲻ���ִ�Сд
// ��Ҫ��Сдת��
// 'a' = 'A' + 32
import java.util.Scanner;

// ע����������Ϊ Main, ��Ҫ���κ� package xxx ��Ϣ
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