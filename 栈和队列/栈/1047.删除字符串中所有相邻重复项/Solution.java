// ����1047 ɾ���ַ��������������ظ���
// ˼·�����������ַ�����ͬʱ���ַ����뵽ջ�����ж�ջ��Ԫ���Ƿ���ַ����

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