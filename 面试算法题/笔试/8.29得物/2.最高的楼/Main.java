import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //楼数量
        int m = in.nextInt(); //总楼高
        int x = in.nextInt(); //x栋可能的高度
        int left = x - 1;   // 左侧楼数量
        int right = n - x;  //右侧楼数量
        int remain = m - n; //剩余楼数量
        int range = 0;
        // 阶梯型 需要判断
        while(remain >= 0){
            // x位置加一米
            remain -= 1;
            remain -= Math.min(left, range);
            remain -= Math.min(right, range);
            range++;
        }
        System.out.print(range);
    }
}