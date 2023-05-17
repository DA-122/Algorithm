// 官解优化
// 一维数组模拟，编号为index的栈顶位置pos = capacity*index+stackTop
// 保存所有被PopAtStack删除的位置
 
import java.util.List;
import java.util.TreeSet;

public class DinnerPlates2 {
    int capacity;
    List<Integer> stack;
    List<Integer> top;
    TreeSet<Integer> poppedPos;

    public void push(int val) {
        if (poppedPos.isEmpty()) {
            int pos = stack.size();
            stack.add(val);
            if (pos % capacity == 0) {
                top.add(0);
            }
            else {
                int stackPos = top.size()-1;
                int stackTop = top.get(stackPos);
                top.set(stackPos, stackTop + 1);
            }
        } else {
            int pos = poppedPos.pollFirst();
            stack.set(pos, val);
            int index = pos / capacity;
            int stackTop = top.get(index);
            top.set(index, stackTop + 1);
        }
    }

    public int pop() {
        while (!stack.isEmpty() && poppedPos.contains(stack.size()-1)) {
            stack.remove(stack.size()-1);
            int pos = poppedPos.pollLast();
            if (pos % capacity == 0) {
                top.remove(top.size()-1);
            }
        }
        if (stack.isEmpty()) {
            return -1;
        } else {
            int pos = stack.size() - 1;
            int val = stack.get(pos);
            stack.remove(pos);
            int index = top.size()-1;
            if (pos % capacity == 0) {
                top.remove(index);
            } else {
                top.set(index, index - 1);
            }
            return val;
        }
    }

    public int popAtStack(int index) {
        if (index >= top.size()) {
            return -1;
        }
        int stackTop = top.get(index);
        if (stackTop < 0) {
            return -1;
        }
        top.set(index, stackTop - 1);
        int pos = index * capacity + stackTop;
        poppedPos.add(pos);
        return stack.get(pos);
    }
}