// 力扣739 每日温度
// 思路分析：单调栈

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution{
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i = 1; i < temperatures.length;i++){
            if(temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args){
        int [] temperatures = {73,74,75,71,69,72,76,73};
        dailyTemperatures(temperatures);
    }
}