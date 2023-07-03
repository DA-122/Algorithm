import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line = in.nextLine();
        int n = line.length();
        int i = n - 1;
        while(i >= 0){
            if(line.charAt(i) == ' '){
                break;
            }
            i--;
        }
        System.out.print(n-i-1);
    }
}