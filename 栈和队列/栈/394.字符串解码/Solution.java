// 力扣394.字符串解码
// 思路分析：1.栈
// 2. 递归

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args){
        String s = "30[a]";
        System.out.println(decodeString(s));
    }
    public static String decodeString(String s) {
        Deque<String> operator = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        int num = 0;
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c >='0' && c <='9')
                num = num *10 +(int)(c - '0');
            else{
                if(num != 0){
                    nums.push(num);
                    num = 0;
                }
                if(c == ']'){
                    StringBuffer buffer = new StringBuffer();
                    StringBuffer sb = new StringBuffer();
                    int times = nums.pop();
                    while(!operator.peek().equals("[") && !operator.isEmpty()){
                        buffer.insert(0,operator.pop());
                    }
                    operator.pop();
                    for(int j = 0; j < times; j++){
                        sb.append(buffer.toString());
                    }
                    operator.push(sb.toString());

                }else{
                    operator.push(Character.toString(c));
                }        
            } 
        }
        StringBuffer buffer = new StringBuffer();
        while(!operator.isEmpty()){
            buffer.append(operator.pollLast());
        }
        return buffer.toString();
    }
}