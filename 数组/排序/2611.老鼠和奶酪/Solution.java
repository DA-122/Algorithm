// 力扣2611 老鼠和奶酪
// 思路分析：贪心加排序
// reward1 - reward2 值按降序排序
public class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int res = 0;
        int [][] rewards = new int[reward1.length][2];
        for(int i = 0 ; i < reward1.length; i++){
            rewards[i][0] = reward1[i];
            rewards[i][1] = reward2[i];
        }
        Arrays.sort(rewards,(a,b) -> (b[0]-b[1]) - (a[0]-a[1]));
        for(int i = 0 ; i < k; i++){
            res += rewards[i][0];
        }
        for(int i = k; i < reward1.length; i++){
            res += rewards[i][1];
        }
        return res;
    }
}
