import java.util.Scanner;

// ע����������Ϊ Main, ��Ҫ���κ� package xxx ��Ϣ
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ע�� hasNext �� hasNextLine ������
        String floarNum = in.nextLine();
        String[] strs = floarNum.split("\\.");
        if(strs[1].charAt(0) < '5'){
            System.out.print(Integer.parseInt(strs[0]));
        }else{
            System.out.print(Integer.parseInt(strs[0]) + 1);
        }
    }
}