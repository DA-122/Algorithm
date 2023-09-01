import java.util.Scanner;

// »¬¶¯´°¿Ú
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        System.out.println(checkBeautify(n, x, str));
    }
    public static int checkBeautify(int n, int x, String str){
        int res = 0;
        for(int i = 0; i < n - x + 1; i++){
            boolean flag = true;
            for(int j = 0; j < x / 2; j++){
                if(str.charAt(i + j) != str.charAt(i + x - 1 - j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res =  1;
                break;
            }
        }
        return res;
    }
}