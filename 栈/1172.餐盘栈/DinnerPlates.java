// ����1172 ����ջ
// ˼·������ջģ��

// �ܹ���200000
// �����ܵ�capacity200000
// ջ����Ϊ200000/capacity

public class DinnerPlates {
    int capacity = 0; //ջ����
    int stackNum = 0; //ջ����
    int [][] stack; //ģ��ջ
    int [] top;    //��¼ÿ��ջ��topλ��
    int left = 0;  //�������ҵ�һ��������ջ
    int right = 0; //���������һ�����յ�ջ

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stackNum = 200000/capacity+1;
        stack = new int[stackNum][capacity];
        top = new int[stackNum];
    }
    
    public void push(int val) {
        stack[left][top[left]] = val;
        // ջ����Ѱ����һ��������ջָ�롣
        if(++top[left] == capacity){
            while(top[left]==capacity){
                left++;
            }
        }
        // ͬʱ����pushʱ��rightָ�롣
        // ���top[left] == 0, right = left-1;
        if(left > right&& top[left] > 0){
            right = left;
        }else if(left > right && top[left] == 0){
            right = left -1;
        }
    }
    public int pop() {
        // ����ջ���ǿ�
        if(right == 0&&top[right] == 0){
            return -1;
        }
        int result = stack[right][--top[right]];
        if(top[right] == 0){
            while(right > 0&&top[right]==0){
                right--;
            }
        }
        if(right < left){
            left = right;
        }
        return result;
    }
    public int popAtStack(int index) {
        if(top[index] == 0 || index >= stackNum){
            return -1;
        }
        int result = stack[index][--top[index]];
        if(index < left){
            left = index;
        }
        if(index == right){
            if(top[right]==0){
                while(right > 0&&top[right]==0){
                    right--;
                }
            }
        }
        return result;
    }
}