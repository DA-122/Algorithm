// ��ָ31 ջ��ѹ�롢��������
// ˼·������ģ��ջ��push��pop������������Ƿ�ջ�ܱ�Ϊ��
// ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n)
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution{
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int left =0, right = 0;
        while(left < pushed.length){
            stack.push(pushed[left]);
            left++;
            // pop����
            while(!stack.isEmpty()){
                if(stack.peek() == popped[right]){
                    stack.pop();
                    right++;
                }else{
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        validateStackSequences(pushed, popped);
    }
}