import java.util.Scanner;

// 动态规划
// 0-1背包问题
// 状态转移 dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])

// 但是有附件， 主件/ 附件1+主件 / 附件2 + 主件 /主件+附件1+附件2
// 可以转化为什么呢? 只看主件，看主件的不同搭配



public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 除以10减小复杂度
        int N = in.nextInt() / 10 ; // 总钱数（容量）
        int m = in.nextInt(); // 物品个数
        // int items[][] = new int[m+1][3];
        int weights[][] = new int[m + 1][4]; // 钱
        int values[][] = new int[m + 1][4]; // 满意度
        // 注意 hasNext 和 hasNextLine 的区别
        for (int i = 1; i <= m; i++) { // 注意 while 处理多个 case
            int p = in.nextInt() / 10; // 价格
            int s = in.nextInt() * p; // 满意度
            int index = in.nextInt();
            // 主件
            if (index == 0) {
                weights[i][0] = p;
                values[i][0] = s;
            } else if (weights[index][1] == 0) {
                // 附件1
                weights[index][1] = p;
                values[index][1] = s;
            } else {
                // 附件2
                weights[index][2] = p;
                values[index][2] = s;
            }
            in.nextLine();
        }

        for(int i = 1; i < m+1; i++){
            // 如果是主件
            if(weights[i][0]!=0){
                weights[i][3] = weights[i][0] + weights[i][1] + weights[i][2];
                weights[i][1] += weights[i][0];
                weights[i][2] += weights[i][0];
                values[i][3] = values[i][0] + values[i][1] + values[i][2];
                values[i][1] += values[i][0];
                values[i][2] += values[i][0];
            } 
        }
        int dp[][] = new int[m + 1][N + 1];
        for (int i = 1; i <= m ; i++) {
            for (int j = 0; j <= N; j++) {
                // 主件
                if (weights[i][0] != 0) {
                    // 不放主件
                    dp[i][j] = dp[i-1][j];
                    for (int k = 0; k < 4 && weights[i][0] != 0; k++) {
                        if (j - weights[i][k] >= 0) {
                            dp[i][j] = Math.max(dp[i - 1][j - weights[i][k]] + values[i][k], dp[i][j]);
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        System.out.print(dp[m][N]*10);
    }
}