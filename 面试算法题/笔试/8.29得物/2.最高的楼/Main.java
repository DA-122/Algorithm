import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //¥����
        int m = in.nextInt(); //��¥��
        int x = in.nextInt(); //x�����ܵĸ߶�
        int left = x - 1;   // ���¥����
        int right = n - x;  //�Ҳ�¥����
        int remain = m - n; //ʣ��¥����
        int range = 0;
        // ������ ��Ҫ�ж�
        while(remain >= 0){
            // xλ�ü�һ��
            remain -= 1;
            remain -= Math.min(left, range);
            remain -= Math.min(right, range);
            range++;
        }
        System.out.print(range);
    }
}