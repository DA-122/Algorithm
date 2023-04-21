// 力扣904 水果成篮
// 思路分析：滑动窗口

public class Solution{
    public static int totalFruit(int[] fruits) {
        // left right指向当前两种水果
        int left = 0;
        int right = left;
        int max = 0;
        while(right <fruits.length && fruits[right] == fruits[left]){
            right++;
        }
        if(right == fruits.length){
            return fruits.length;
        }
        // pivot 寻找下一种不同的水果
        int pivot = right+1;
        // leftL 和 rightL保存两种水果最后一次出现的位置
        int leftL = right-1;
        int rightL = right;
    
        while(right < fruits.length){
            while(pivot < fruits.length){
                if(fruits[pivot] == fruits[left]){
                    leftL = pivot;
                }else if(fruits[pivot] == fruits[right]){
                    rightL = pivot;
                }else{
                    break;
                }
                pivot++;
            }
            max = Math.max(pivot - left, max);
            right = pivot;
            pivot = right+1;
            // 新的左侧水果是上一轮右侧水果
            left = Math.min(leftL, rightL)+1;
            // 更新两种水果上一次出现的最后位置（一定是前后关系）
            leftL = right -1;
            rightL = right;
        }
        return max;
    }
    public static void main(String[] args){
        int[] fruits ={1,0,3,4,3};
        System.out.println(totalFruit(fruits));
    }
}