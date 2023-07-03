import java.util.HashMap;
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

// ע����������Ϊ Main, ��Ҫ���κ� package xxx ��Ϣ
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
    // i ���� ǰһ�������� j ����ǰ����
    // > �������ȼ��㣬 < ��������ѹ��ջ
    // �˳������ڼӼ�
    // ��ͬ����������ջ(���)����
    // '('���ڼӼ��˳������Ӽ��˳�����')'

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
                // ��������ջ
                if(cur != i){
                    operand.push(Integer.parseInt(str.substring(cur,i)));
                }
                cur = i + 1;
                // �Աȵ�ǰ������ջ�����������ȼ�
                // ���ȼ���  ���ù�
                // ���ȼ��ͻ�� ��ʼ��ջ��������
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
                    // '=' ����'('
                    operator.pop();
                }
            }
        }
        return operand.peek();
    }
    public boolean isDigits(char c){
        return c <='9' && c>='0';
    }

    // b ��ǰ������
    // a ջ��������
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