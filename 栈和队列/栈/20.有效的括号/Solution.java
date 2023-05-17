// 力扣20.有效的括号
// 思路分析：简单的栈应用


import java.util.Deque;

public class Solution{
    public static boolean isValid(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        for(char word: s.toCharArray()){
            if(word =='{' || word =='(' || word =='['){
                queue.push(word);
            }else{
                if(word == '}'){
                    if(queue.isEmpty() || queue.pop()!='{'){
                        return false;
                    }
                }
                if(word == ')'){
                    if(queue.isEmpty() || queue.pop()!='('){
                        return false;
                    }
                }
                if(word == ']'){
                    if(queue.isEmpty() || queue.pop()!='['){
                        return false;
                    }
                }
            }
        }
        return queue.isEmpty();
    }
    public static void main(String[] args){
    

    }
}