// TreeSet 排序+去重

import java.util.Scanner;
import java.util.TreeSet;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = Integer.parseInt(in.nextLine());
        TreeSet<Integer> set= new TreeSet<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            set.add(Integer.parseInt(in.nextLine()));
        }
        for(int num: set){
            System.out.println(num);
        }
    }
}