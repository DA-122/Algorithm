import java.util.HashMap;
import java.util.Map;

// 力扣1027 最长等差数列
// 思路分析：动态规划
public class Solution{
    public static int longestArithSeqLength(int[] nums) {
        Map<Integer,Integer>[] dp = new HashMap[nums.length];
        for(int i = 0; i < dp.length; i++){
            dp[i] = new HashMap<Integer,Integer>();
        }
        int max = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                int differ = nums[i] -nums[j];
                dp[i].put(differ, dp[j].getOrDefault(differ,0)+1);
                if(dp[i].get(differ) > max){
                    max = dp[i].get(differ);
                }
            }
        }
        return max+1;
    }
    public static void main(String[] args){
        int[] nums = {9,4,7,2,10};
        System.out.println(longestArithSeqLength(nums));
    }
}