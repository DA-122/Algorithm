import java.util.Scanner;
import java.util.ArrayList;

// 质因数
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int num = in.nextInt();
        getPrime(num);


    }
    public static void getPrime(int num) {
        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                while (num % i == 0) {
                    num = num / i;
                    System.out.print(i + " ");
                }
                if(isPrime(num)){
                    System.out.print(num);
                    num = 1;
                }
            }
        }
    }
    public static boolean isPrime(int num) {
        if(num == 1){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}