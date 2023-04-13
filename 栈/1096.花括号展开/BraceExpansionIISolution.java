import java.util.*;
// Á¦¿Û1096 À¨ºÅÆ¥

// 
public class BraceExpansionIISolution {
    public static List<String> braceExpansionII(String expression) {
        Stack<Character> operation = new Stack<Character>();
        Stack<List<String>> operator = new Stack<List<String>>();
        for(int i = 0; i < expression.length();i++){

        }
        Collections.sort(operator.peek());
        return operator.peek();
    }
    public static void main(String[] args){
        String testCase = "{{a,z},a{b,c},{ab,z}}";
        System.out.println(braceExpansionII(testCase));
    }
}
