// 力扣150.逆波兰表达式
// 思路分析：逆波兰表达式 后缀表达式，算子 算子 操作符的顺序的表达式
// 栈实现。


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution{
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s : tokens){
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                int op1 = stack.pop();
                int op2 = stack.pop();
                int result = 0;
                if(s.equals("+")){
                    result = op1 + op2;
                    stack.push(result);
                    continue;
                }
                if(s.equals("-")){
                    result = op2 - op1;
                    stack.push(result);
                    continue;
                }
                if(s.equals("*")){
                    result = op1 * op2;
                    stack.push(result);
                    continue;
                }
                if(s.equals("/")){
                    result = op2 / op1;
                    stack.push(result);
                    continue;
                }
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        String[] tokens = {"4","13","5","/","+"};
        evalRPN(tokens);
    }
}