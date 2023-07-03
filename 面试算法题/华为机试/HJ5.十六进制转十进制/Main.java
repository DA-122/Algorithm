import java.util.HashMap;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);

        // 注意 hasNext 和 hasNextLine 的区别
        String num0x = in.nextLine();

        int cnt = 0;
        int res = 0;
        for(int i = num0x.length()-1; i >=2; i--){
            int num = map.get(num0x.charAt(i));
            res += Math.pow(16,cnt)* num ;
            cnt++;
        }
        System.out.print(res);
        
    }
}