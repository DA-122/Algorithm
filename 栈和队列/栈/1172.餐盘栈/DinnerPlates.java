// 力扣1172 餐盘栈
// 思路分析：栈模拟

// 总共才200000
// 所以总的capacity200000
// 栈数量为200000/capacity

public class DinnerPlates {
    int capacity = 0; //栈容量
    int stackNum = 0; //栈数量
    int [][] stack; //模拟栈
    int [] top;    //记录每个栈的top位置
    int left = 0;  //从左向右第一个不满的栈
    int right = 0; //从右向左第一个不空的栈

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stackNum = 200000/capacity+1;
        stack = new int[stackNum][capacity];
        top = new int[stackNum];
    }
    
    public void push(int val) {
        stack[left][top[left]] = val;
        // 栈满，寻找下一个不满的栈指针。
        if(++top[left] == capacity){
            while(top[left]==capacity){
                left++;
            }
        }
        // 同时更新push时的right指针。
        // 如果top[left] == 0, right = left-1;
        if(left > right&& top[left] > 0){
            right = left;
        }else if(left > right && top[left] == 0){
            right = left -1;
        }
    }
    public int pop() {
        // 所有栈都是空
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