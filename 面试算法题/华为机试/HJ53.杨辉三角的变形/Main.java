// 找规律


import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextLine()){
            int num = Integer.parseInt(in.nextLine());
            getEven(num);
        }

    }

    // 找规律
    public static void getEven(int num){
        if (num == 1 || num == 2 ){
            System.out.print(-1);
        }else if((num - 2) % 4 ==0){
            System.out.print(4);
        }
        else if (num % 2 == 1){
            System.out.print(2);
        }else{
            System.out.print(3);
        }
    }
}