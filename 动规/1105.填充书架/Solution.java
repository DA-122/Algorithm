// ����1105.������
// ˼·����: ��˳����ڷŵ��ܿ��ΪSelfWidth������ϣ�
// ��dp[i]��ʾǰi�������õ���С�߶ȣ����Էֽ��ǰj�������С�߶ȣ��������һ����(k)�����߶�
// ���ƹ�ʽ: dp[i] = Math.min(dp[j] + max(books[k]))  j <= k < i 
// ��ʼ��: dp[0] = 0; dp[i] = 10000000(����)
// ����˳��: ��ǰ����

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
                // Ѱ��k�����е�maxHeight
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