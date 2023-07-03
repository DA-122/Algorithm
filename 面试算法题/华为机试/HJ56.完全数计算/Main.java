import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n == 1){
            System.out.print(0);
        }
        int res = 0;
        for(int i = 2; i <=n; i++){
            if(compute(i)){
                res++;
            }
        }
        System.out.print(res);
    }
    public static boolean compute(int num){
        boolean res = true;
        int sum = 1;
        for(int i = 2; i <= num/2; i++){
            if(num % i == 0){
                sum+=i;
                
            }
        }
        return sum==num;
    }
}