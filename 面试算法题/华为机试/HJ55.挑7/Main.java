// ö��
import java.util.Scanner;

// ע����������Ϊ Main, ��Ҫ���κ� package xxx ��Ϣ
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