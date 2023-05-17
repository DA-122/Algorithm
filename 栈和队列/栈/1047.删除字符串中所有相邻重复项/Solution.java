// 力扣1047 删除字符串中所有相邻重复项
// 思路分析：遍历字符串的同时将字符加入到栈，并判断栈顶元素是否和字符相等

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        for(char word : s.toCharArray()){
            if(!queue.isEmpty()){
                if(queue.peek() == word){
                    queue.pop();
                }else{
                    queue.push(word);
                }
            }else{
                queue.push(word);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!queue.isEmpty()){
            sb.insert(0,queue.pop());
        }
        return sb.toString();

    }
}