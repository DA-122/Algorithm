// 力扣2679. 矩阵中的和

// 每行排序，然后删除每一列的最大元素

public class Solution {
    public int matrixSum(int[][] nums) {
        int res = 0;
        // 行排序
        for(int i = 0; i < nums.length; i++){
            Arrays.sort(nums[i]);
        }
        for(int i = 0; i < nums[0].length; i++){
            int max = 0;
            for(int j = 0; j < nums.length; j++){
                max = Math.max(nums[j][i],max);                
            }
            res+=max;
        }
        return res;
    }
}