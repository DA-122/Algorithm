// 力扣1105.填充书架
// 思路分析: 按顺序将书摆放到总宽度为SelfWidth的书架上，
// 用dp[i]表示前i本书所用的最小高度，可以分解成前j本书的最小高度，加上最后一层书(k)的最大高度
// 递推公式: dp[i] = Math.min(dp[j] + max(books[k]))  j <= k < i 
// 初始化: dp[0] = 0; dp[i] = 10000000(大数)
// 遍历顺序: 从前往后

import java.util.Arrays;

public class Solution{
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp,1000000);
        dp[0] = 0;
        for(int i = 0; i < n; i++){
            int maxHeight = 0, curWidth = 0;
            for(int j = i; j >=0; j--){
                curWidth+=books[j][0];
                if(curWidth > shelfWidth){
                    break;
                }
                // 寻找k本书中的maxHeight
                maxHeight = Math.max(maxHeight,books[j][1]);
                dp[i+1] = Math.min(dp[j]+maxHeight,dp[j+1]);
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        int[][] books ={{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelfWidth = 4;
        minHeightShelves(books,shelfWidth);

    }
}