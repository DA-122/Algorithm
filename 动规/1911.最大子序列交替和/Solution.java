// 注意这道题全是正数,负数方法不一定适用
// 时间复杂度要求O(n)

// 法1、局部单调性
// 将原数组按照奇偶分割为k个单调区间
// 每次取单调区间最右边的数
// 法2、动态规划
// 法3、滚动数组优化，每次f[i] g[i]状态仅与f[i-1] g[i-1]有关
// 有题解说 类似于买卖股票时机Ⅱ
 
public class Solution {
    // 法3
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long even = nums[0], odd = 0;
        for(int i = 1; i < n; i++){
            even = Math.max(odd + nums[i], even);
            odd = Math.max(even - nums[i], odd);
        }
        return Math.max(even,odd);
    }
}
