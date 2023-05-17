// 有问题，未解决

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution{
    public static int trap(int[] height) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        for(int i = 1; i < height.length;i++){
            if(height[i] < height[stack.peek()]){
                stack.push(i);
            }else{
                result += (i-stack.peekLast()-1)*height[stack.peekLast()];
                while(stack.size()!=1){
                    result -= height[stack.pop()];
                }
                stack.pop();
                stack.push(i);
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}