import java.util.Scanner;

// ע����������Ϊ Main, ��Ҫ���κ� package xxx ��Ϣ
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ע�� hasNext �� hasNextLine ������
        String line = in.nextLine();
        int n = line.length();
        int i = n - 1;
        while(i >= 0){
            if(line.charAt(i) == ' '){
                break;
            }
            i--;
        }
        System.out.print(n-i-1);
    }
}