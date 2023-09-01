// 力扣42. 接雨水
// 思路分析：此题重在理解如何计算积水
//法1：按行计算（无法AC）
//法2：按列计算，对于每一列，分别寻找左右两边最大高度
// 记左边最大高度 max_left, 右边最大高度 max_right
// 如果 min(max_left, max_right) > height[i] 此列会盛水
// 如果 min(max_left, max_right) < height[i] 此列不可能盛水
// 法3：动态规划，法2中每次都遍历寻找左侧右侧最大值，重复太多次，可以用空间换时间，
// 法4：双指针优化空间复杂度：可以看到法三中定义的max_left数组和max_right数组每一位我们都只用了一次，因此不需要两个数组，保留一个数组和一个指针就行。
// 法5：单调栈 
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution{
    // 按列
    public static int trap1(int[] height) {
        int sum = 0 ;
        for(int i = 1; i < height.length - 1; i++){
            int max_left = 0;
            for(int j  = i -1; j >=0; j--){
                if(height[j] > max_left){
                    max_left = height[j];
                }
            }
            int max_right = 0;
            for(int j = i + 1; j < height.length; j++){
                if(height[j] > max_right){
                    max_right = height[j];
                }
            }
            int minHeight = Math.min(max_left,max_right);
            if(minHeight > height[i]){
                sum += minHeight - height[i];
            }else{
                continue;
            }
        }
        return sum;
    }
    // 动规
    public static int trap2(int[] height) {
        int sum = 0 ;
        int n = height.length;
        int max_lefts[] = new int[n];
        int max_rights[] = new int[n];
        int max_left = height[0];
        int max_right = height[n-1];
        for(int i = 1; i < n ; i++){
            max_lefts[i] = max_left;
            max_left = Math.max(max_left, height[i]);
        }

        for(int i = n - 2; i > 0; i--){
            max_rights[i] = max_right;
            max_right =Math.max(max_right,height[i]);
        }
        for(int i = 1; i < n-1; i++){
            int minHeight = Math.min(max_lefts[i],max_rights[i]);
            if(minHeight > height[i]){
                sum+= minHeight - height[i];
            }
        }
        return sum;
    }
    // 缩减空间复杂度
    public int trap3(int[] height) {
        int sum = 0 ;
        int n = height.length;
        int max_rights[] = new int[n];
        int max_left = height[0];
        int max_right = height[n-1];

        for(int i = n - 2; i > 0; i--){
            max_rights[i] = max_right;
            max_right =Math.max(max_right,height[i]);
        }
        for(int i = 1; i < n-1; i++){
            int minHeight = Math.min(max_left,max_rights[i]);
            if(minHeight > height[i]){
                sum+= minHeight - height[i];
            }
            max_left = Math.max(max_left,height[i]);
        }
        return sum;
    }
    // 单调栈
    public int trap4(int [] height){
        int sum = 0 ;
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i = 1; i < n ; i++){
            if(height[i] > height[stack.peek()]){
                // 栈顶出栈 并计算
                while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                    int h = height[stack.pop()];
                    if(stack.isEmpty()){
                        break;
                    }
                    // 可以看作是法2中每列积水的求法
                    int distance =  i - stack.peek()-1;
                    int min = Math.min(height[i],height[stack.peek()]);
                    sum += distance *  (min - h);
                }
                // 计算积水
            }
            stack.push(i);
            
        }
        return sum;
    }



    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap4(height));
    }
}