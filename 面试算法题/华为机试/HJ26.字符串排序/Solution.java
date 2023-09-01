import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        List<List<Character>> list = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            list.add(new ArrayList<Character>());
        }
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= 'a' && c <='z'){
                list.get(c-'a').add(c);
            }else if(c >='A'&& c<='Z'){
                list.get(c-'A').add(c);
            }
        }
        int a = 0;
        int b = 0;
        StringBuilder bulider = new StringBuilder();
        for(char c : str.toCharArray()){ 
            if(c <='Z' && c>='A' || c>='a' && c<='z'){
                while(b == list.get(a).size()){
                    a++;
                    b=0;
                }
                bulider.append(list.get(a).get(b));
                b++;
            }else
                bulider.append(c);
        }
        System.out.print(bulider.toString());
    }
}