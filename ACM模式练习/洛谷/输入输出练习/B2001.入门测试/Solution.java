import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = Long.parseLong(sc.next());
        long b = Long.parseLong(sc.next());
        long c = a+b;
        sc.close();
        System.out.print(c);
    }
}
