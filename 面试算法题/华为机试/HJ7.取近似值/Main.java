import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String floarNum = in.nextLine();
        String[] strs = floarNum.split("\\.");
        if(strs[1].charAt(0) < '5'){
            System.out.print(Integer.parseInt(strs[0]));
        }else{
            System.out.print(Integer.parseInt(strs[0]) + 1);
        }
    }
}