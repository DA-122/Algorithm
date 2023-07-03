// 枚举
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        for(int i = 1; i <= n ; i++){
            if(i % 7 == 0){
                res++;
            }else{
                int cur = i;
                while(cur != 0){
                    if(cur % 10 == 7){
                        res++;
                        break;
                    }
                    cur = cur /10;
                }
            }
        }
        System.out.print(res);
    }
}