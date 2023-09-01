import java.util.Scanner; 
import java.util.Set;
import java.util.HashSet;
// 长度超过八位
// 包括大小写字母、数字、其他符号，至少含有三种
// 不能有长度大于2的包含公共元素的子串重复

// 思路分析： HashSet

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String password = in.nextLine();
            if(isValid(password)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
    public static boolean isValid(String password){
        if(password.length() <= 8){
            return false;
        }
        int count = 0;
        int [] cnt = new int[4];
        for(char c: password.toCharArray()){
            if(c >='0' && c <='9'){
                cnt[0]++;
            }else if(c >='a' && c <='z'){
                cnt[1]++;
            }else if(c >='A' && c <='Z'){
                cnt[2]++;
            }else{
                cnt[3]++;
            }
        }
        for(int i = 0; i < 4; i++){
            if(cnt[i] != 0){
                count++;
            }
        }
        if(count < 3){
            return false;
        }
        // 滑动窗口
        Set<String> set = new HashSet<>();
        for(int i = 3; i < password.length(); i++){
            for(int j = 0; j + i <= password.length(); j++){
                String sub = password.substring(j,j+i);
                if(set.contains(sub)){
                    return false;
                }else{
                    set.add(sub);
                }
            }
        }
        return true;
    }
}