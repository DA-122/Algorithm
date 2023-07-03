import java.util.HashMap;
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // String str = in.nextLine();
        String str = "(7+5*4*3+6))";
        Computer com = new Computer();
        System.out.print(com.parseAndCompute(str));

    }
}
class Computer{
    private HashMap<Character, Integer> map =new HashMap<>();
    // i 代表 前一个操作， j 代表当前操作
    // > 代表优先计算， < 代表不操作压入栈
    // 乘除优先于加减
    // 相同操作，先入栈(左边)优先
    // '('优于加减乘除，但加减乘除优于')'

    private char[][] compareTable = {{'>','>','<','<','<','>','>'},
    {'>','>','<','<','<','>','>'},
    {'>','>','>','>','<','>','>'},
    {'>','>','>','>','<','>','>'},
    {'<','<','<','<','<','=','O'},
    {'>','>','>','>','O','>','>'},
    {'<','<','<','<','<','O','='}};

    public Computer(){
        map.put('+',0);
        map.put('-',1);
        map.put('*',2);
        map.put('/',3);
        map.put('(',4);
        map.put(')',5);
        map.put('#',6);



    }

    public int parseAndCompute(String str){
        str +='#';
        int n = str.length();
        int cur = 0;
        Deque<Integer> operand = new ArrayDeque<>();
        Deque<Character> operator = new ArrayDeque<>();
        operator.push('#');
        for(int i = 0; i < n ;i++){
            char word = str.charAt(i);
            if(!isDigits(word)){
                // 操作数入栈
                if(cur != i){
                    operand.push(Integer.parseInt(str.substring(cur,i)));
                }
                cur = i + 1;
                // 对比当前操作和栈顶操作的优先级
                // 优先级高  不用管
                // 优先级低或等 开始弹栈，弹到高
                if(compare(operator.peek(),word) == '>'){
                    while(compare(operator.peek(),word) == '>'){
                        int a = operand.pop();
                        int b = operand.pop();
                        char c = operator.pop();
                        operand.push(compute(a,b,c));
                    }
                    if(compare(operator.peek(),word) == '<'){
                        operator.push(word);
                    }else{
                        operator.pop();
                    }
                }else if(compare(operator.peek(),word) == '<'){
                    operator.push(word);
                }else{
                    // '=' 弹出'('
                    operator.pop();
                }
            }
        }
        return operand.peek();
    }
    public boolean isDigits(char c){
        return c <='9' && c>='0';
    }

    // b 当前操作符
    // a 栈顶操作符
    public char compare(char a, char b){
        return compareTable[map.get(a)][map.get(b)];
    }
    public int compute(int a, int b, char c){
        int res = 0;
        switch(c){
            case '+':
                res =  a + b;
                break;
            case '-':
                res = b - a;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = b / a;
        }
        return res;
    }
    
}