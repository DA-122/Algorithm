// �ҹ���


import java.util.Scanner;

// ע����������Ϊ Main, ��Ҫ���κ� package xxx ��Ϣ
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextLine()){
            int num = Integer.parseInt(in.nextLine());
            getEven(num);
        }

    }

    // �ҹ���
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