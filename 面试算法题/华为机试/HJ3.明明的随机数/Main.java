// TreeSet ����+ȥ��

import java.util.Scanner;
import java.util.TreeSet;

// ע����������Ϊ Main, ��Ҫ���κ� package xxx ��Ϣ
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = Integer.parseInt(in.nextLine());
        TreeSet<Integer> set= new TreeSet<>();
        // ע�� hasNext �� hasNextLine ������
        while (in.hasNextInt()) { // ע�� while ������ case
            set.add(Integer.parseInt(in.nextLine()));
        }
        for(int num: set){
            System.out.println(num);
        }
    }
}