// 力扣1033 移动石子直到连续
// 模拟
import java.util.Arrays;

public class Solution{
    public int[] numMovesStones(int a, int b, int c) {
        int stones[] = new int[3];
        stones[0] = a; 
        stones[1] = b;
        stones[2] = c;
        Arrays.sort(stones);
        int ans[]  = new int[2];
        // 最大很好想象，假如stones[2]到stones[0]有k个空位，将其全部填满即是最大
        ans[1] = stones[2]-stones[0]-2;
        // 最小分三种情况
        if((stones[2]==stones[1]+1)&&(stones[1] == stones[0]+1)){
            ans[0] = 0;
        }else if(stones[2] - stones[1] <= 2 || stones[1] - stones[0] <=2 ){
            ans[0] = 1;
        }else{
            ans[0] = 2;
        }
        return ans;
    }
}