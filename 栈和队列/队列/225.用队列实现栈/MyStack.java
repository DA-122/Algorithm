// ����225. �ö���ʵ��ջ
// ˼·������1.ÿ��pop����topʱ������һ���ǿյĶ����뵽��һ�������У�ȡ���һ��Ԫ�ء�
// 2.ÿ��push�󣬽���Ԫ��ǰ��Ԫ�ض�poll������push��ȥ���γɷ���

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {
    Deque<Integer> queue1 ;
    Deque<Integer> queue2;
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        int result = 0;
        // queue1��popԪ����queue1
        if(!queue1.isEmpty()){
            while(!queue1.isEmpty()){
                if(queue1.size() == 1){
                    result = queue1.poll();
                }else
                    queue2.offer(queue1.poll());
            }
        }else{
            while(!queue2.isEmpty()){
                if(queue2.size()==1){
                    result = queue2.poll();
                }else{
                    queue1.offer(queue2.poll());
                }
            }
        }
        return result;
    }
    
    public int top() {
        int result = 0;
        // queue1��popԪ����queue1
        if(!queue1.isEmpty()){
            while(!queue1.isEmpty()){
                result = queue1.poll();
                queue2.offer(result);
            }
        }else{
            while(!queue2.isEmpty()){
                result = queue2.poll();
                queue1.offer(result);
            }
        }
        return result;
    }
    
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */