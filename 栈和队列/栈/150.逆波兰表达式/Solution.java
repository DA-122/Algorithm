// ����150.�沨�����ʽ
// ˼·�������沨�����ʽ ��׺���ʽ������ ���� ��������˳��ı��ʽ
// ջʵ�֡�


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