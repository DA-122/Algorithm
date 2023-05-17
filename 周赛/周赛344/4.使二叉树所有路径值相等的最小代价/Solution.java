// 4.使二叉树所有路径值相等的最小价值
// 思路分析：贪心算法
// 对于每对兄弟叶子节点，除了本节点值不同，其他值都相等，改动值为max - min
// 对于每对非叶子兄弟节点，除了本节点值与孩子节点值不同，其他值都相同，改动值为max - min
// 因此可以总结为除自身往下的路径值不同，其他值都相同
public class Solution{


    public int minIncrements(int n, int[] cost) {
        int result = 0;
        // 从最后一个叶子节点开始
        for(int i = n/2-1; i >= 0; i--){
            result += Math.abs(cost[i*2+1]- cost[i*2+2]);
            // 更新parent cost
            cost[i] = cost[i] + Math.max(cost[i*2+1],cost[i*2+2]);
        }
        return result;
    }


    public static void main(String[] args){
    

    }
}